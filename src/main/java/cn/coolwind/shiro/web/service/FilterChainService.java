package cn.coolwind.shiro.web.service;

import cn.coolwind.shiro.core.shiro.MyShiroFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FilterChainService {
    @Autowired
    private MyShiroFactoryBean shiroFactoryBean;

    public void reloadFilterChain() {
        synchronized (shiroFactoryBean) { //确保同步
            AbstractShiroFilter shiroFilter;
            try {
                //获取管理器
                shiroFilter = (AbstractShiroFilter) shiroFactoryBean.getObject();
                PathMatchingFilterChainResolver resolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
                DefaultFilterChainManager manager = (DefaultFilterChainManager) resolver.getFilterChainManager();
                //清除权限配置
                manager.getFilterChains().clear();
                shiroFactoryBean.getFilterChainDefinitionMap().clear();
                //重新从数据库获取权限
                shiroFactoryBean.setFilterChainDefinitions(MyShiroFactoryBean.definitions);
                //取出新的配置
                Map<String, String> chainMap = shiroFactoryBean.getFilterChainDefinitionMap();
                //配置过滤链
                if (!CollectionUtils.isEmpty(chainMap)) {
                    for (String key :chainMap.keySet()) {
                        manager.createChain(key,chainMap.get(key));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
