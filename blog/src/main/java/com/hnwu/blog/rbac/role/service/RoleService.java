package com.hnwu.blog.rbac.role.service;

import com.hnwu.blog.rbac.role.Role;

import java.util.List;

/**
 * 角色服务
 * Created by 吴会楠 on 2018/1/2.
 */
public interface RoleService {
    /**
     * 根据用户获取用户所拥有的权限
     */
    List<Role> getRolesByUserId(Integer userId);

    /**
     * 根据Id 获取Role信息
     */
    Role queryRoleById(Integer roleId);

    /**
     * 根据menuId获取对应的权限列表
     */
    List<Role> queryRolesByMenuId(Integer menuId);

    /**
     * 查询角色的列表
     */
    List<Role> queryRoles();
}
