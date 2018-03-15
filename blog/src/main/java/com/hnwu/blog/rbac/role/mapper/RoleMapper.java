package com.hnwu.blog.rbac.role.mapper;

import com.hnwu.blog.rbac.role.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 吴会楠 on 2018/1/2.
 */
public interface RoleMapper {

    @Select("select tr.* from t_user_role tur, t_user tu,t_role tr where tu.id=tur.userid and tur.roleid and tu.id=#{userId}")
    List<Role> getRolesByUserId(Integer userId);

    @Select("select * from t_role where id=#{roleId}")
    Role queryRoleById(Integer roleId);

    @Select("select tr.* from t_role tr,t_role_menu trm where  trm.roleid=tr.id and trm.menuid=#{menuId}")
    List<Role> queryRolesByMenuId(Integer menuId);

    @Select("select * from t_role")
    List<Role> queryRoles();

    @Insert("insert into t_role (rolename,description) values (role.rolename,role.description)")
    @Options(useGeneratedKeys = true, keyProperty = "role.id")
    int addRole(@Param("role") Role role);

    @Update("update t_role t set t.rolename=role.rolename and t.description=role.description where t.id=role.id")
    int updateRole(@Param("role") Role role);

    @Delete("delete from t_role t where t.id=#{id}")
    int deleteRole(Integer id);
}
