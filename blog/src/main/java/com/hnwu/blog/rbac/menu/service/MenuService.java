package com.hnwu.blog.rbac.menu.service;

import com.hnwu.blog.rbac.menu.Menu;

import java.util.List;

/**
 * 菜单资源服务
 * Created by 吴会楠 on 2018/1/2.
 */
public interface MenuService {
    /**
     * 根据RoleId获取菜单的列表
     */
    List<Menu> queryMenusByRoleId(Integer roleId);

    /**
     * 根据UserId获取列表菜单
     */
    List<Menu> queryMenusByUserId(Integer userId);

    /**
     * 菜单列表
     */
    List<Menu> queryMenus();

}
