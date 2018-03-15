package com.hnwu.blog.rbac.user.service.impl;

import com.hnwu.blog.rbac.user.User;
import com.hnwu.blog.rbac.user.entity.UserEntity;
import com.hnwu.blog.rbac.user.mapper.UserMapper;
import com.hnwu.blog.rbac.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 * Created by 吴会楠 on 2018/1/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public List<User> queryUsersByRoleId(Integer roleId) {
        return userMapper.queryUsersByRoleId(roleId);
    }

    @Override
    public User saveOrUpdate(User user) {
        if(user != null && user.getId() != null){
            userMapper.addUser(user);
        }else {
            userMapper.updateUser(user);
        }
        return user;
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.queryUsers();
    }

    @Override
    public UserEntity queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }


}
