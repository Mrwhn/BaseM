package com.hnwu.shiro.rbac.menu.service.impl;


import com.hnwu.shiro.rbac.menu.Menu;
import com.hnwu.shiro.rbac.menu.mapper.MenuMapper;
import com.hnwu.shiro.rbac.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单服务实现类
 * Created by 吴会楠 on 2018/1/2.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryMenusByRoleId(Integer roleId) {
        return menuMapper.queryMenusByRoleId(roleId);
    }

    @Override
    public List<Menu> queryMenusByUserId(Integer userId) {
        return menuMapper.queryMenusByUserId(userId);
    }

    @Override
    public List<Menu> queryMenus() {
        return menuMapper.queryMenus();
    }
}
