package com.hnwu.blog.rbac.role.service.impl;

import com.hnwu.blog.rbac.role.Role;
import com.hnwu.blog.rbac.role.mapper.RoleMapper;
import com.hnwu.blog.rbac.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务实现类
 * Created by 吴会楠 on 2018/1/2.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return roleMapper.getRolesByUserId(userId);
    }

    @Override
    public Role queryRoleById(Integer roleId) {
        return roleMapper.queryRoleById(roleId);
    }

    @Override
    public List<Role> queryRolesByMenuId(Integer menuId) {
        return roleMapper.queryRolesByMenuId(menuId);
    }

    @Override
    public List<Role> queryRoles() {
        return roleMapper.queryRoles();
    }
}
