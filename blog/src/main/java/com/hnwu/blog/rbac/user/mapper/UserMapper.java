package com.hnwu.blog.rbac.user.mapper;

import com.hnwu.blog.rbac.user.User;
import com.hnwu.blog.rbac.user.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * UserMapper映射类
 * Created by 吴会楠 on 2018/1/2.
 */
public interface UserMapper {
    @Select("select * from t_user where id=#{id}")
    User queryUserById(Integer userId);

    @Select("select * from t_user tu,t_user_role tr where tu.id=tr.userId and tr.roleId=#{roleId}")
    List<User> queryUsersByRoleId(Integer roleId);

    @Select("select * from t_user")
    List<User> queryUsers();

    @Insert("insert into t_user (username,description) values (user.username,user.description)")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    int addUser(@Param("user") User user);

    @Update("update t_user t set t.username=user.username and t.description=user.description where t.id=user.id")
    int updateUser(@Param("user") User user);

    @Delete("delete from t_user t where t.id=#{id}")
    int deleteUser(Integer id);

    @Select("select tu.id,tu.username,tu.password,group_concat(tr.rolename) roles from t_user tu,t_user_role tur,t_role tr where tu.id=tur.userid and tur.roleid=tr.id and tu.username=#{username}")
    UserEntity queryUserByName(String username);
}
