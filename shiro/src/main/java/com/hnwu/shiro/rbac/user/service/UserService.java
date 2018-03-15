package com.hnwu.shiro.rbac.user.service;

import com.hnwu.shiro.rbac.user.User;
import com.hnwu.shiro.rbac.user.entity.UserEntity;

import java.util.List;

/**
 * 用户服务
 * Created by 吴会楠 on 2018/1/2.
 */
public interface UserService {
    /**
     * 根据用户编号查询用户
     * @param userId 用户Id
     * @return 用户实体
     */
    User queryUserById(Integer userId);

    /**
     * 根据角色编号获取拥有该角色的用户
     * @param roleId 角色ID
     * @return 用户列表
     */
    List<User> queryUsersByRoleId(Integer roleId);

    /**
     * 保存或更新用户数据
     * @param user 待更新用户信息
     * @return 更新后用户信息
     */
    int saveOrUpdate(User user);

    /**
     * 查询用户的列表
     * @return 用户列表
     */
    List<User> queryUsers();

    UserEntity queryUserByName(String username);

    int saveUserRole(String userId,String ... roleId);
}
