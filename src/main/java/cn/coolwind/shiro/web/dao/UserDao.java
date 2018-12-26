package cn.coolwind.shiro.web.dao;

import cn.coolwind.shiro.web.entity.RoleResource;
import cn.coolwind.shiro.web.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User getByUsername(String username);

    List<String> getRoleByUsername(String userName);

    List<RoleResource> getAllRolesResources();

    void deleteRoleResourceRelation(int roleId);

    void insertRoleResourceRelateionBatch(Map map);
}
