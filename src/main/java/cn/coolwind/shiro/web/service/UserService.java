package cn.coolwind.shiro.web.service;

import cn.coolwind.shiro.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private FilterChainService filterChainService;

    public void changeRoleResource() {
        Map<String,Object> map = new HashMap<>();
        map.put("role", 2);
        int[] list = new int[]{1, 2, 3};
        map.put("list",list);
        userDao.deleteRoleResourceRelation(2);
        userDao.insertRoleResourceRelateionBatch(map);
        filterChainService.reloadFilterChain();
    }
}
