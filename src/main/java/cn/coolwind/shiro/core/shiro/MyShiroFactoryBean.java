package cn.coolwind.shiro.core.shiro;

import cn.coolwind.shiro.web.dao.UserDao;
import cn.coolwind.shiro.web.entity.RoleResource;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class MyShiroFactoryBean extends ShiroFilterFactoryBean {

    public static String definitions = "";

    @Autowired
    private UserDao userDao;

    @Override
    public void setFilterChainDefinitions(String definitions) {
        //在启动时记录配置文件里设置的静态过滤链
        this.definitions = definitions;
        //获取角色以及权限的对应关系
        List<RoleResource> roles = userDao.getAllRolesResources();
        //组装权限
        Map<String,String> chains = new HashMap<>();
        for (RoleResource role :roles) {
            String url = role.getResource();
            String hasRole = chains.get(url);
            if (hasRole != null) {
                chains.put(url,hasRole+",roles["+role.getRole()+"]");
            }else {
                chains.put(url, "roles[" + role.getRole() + "]");
            }
        }
        //加载配置默认的过滤链
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (section == null || section.isEmpty()) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        //加上数据库中过滤链
        section.putAll(chains);
        section.put("/**", "authc");
        setFilterChainDefinitionMap(section);
    }
}
