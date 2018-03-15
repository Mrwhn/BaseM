package com.hnwu.blog.rbac.menu.mapper;

import com.hnwu.blog.rbac.menu.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 吴会楠 on 2018/1/2.
 */
public interface MenuMapper {
    @Select("select tm.* from t_role tr,t_role_menu trm,t_menu tm where tr.id=trm.roleid and tm.id=trm.menuid and tr.id=#{roleId}")
    List<Menu> queryMenusByRoleId(Integer roleId);

    @Select("select tm.* from t_user_role tur,t_role_menu trm,t_menu tm where tur.roleid=trm.roleid and trm.menuid=tm.id and tur.userid=#{userId}")
    List<Menu> queryMenusByUserId(Integer userId);

    @Select("select * from t_menu")
    List<Menu> queryMenus();

    @Insert("insert into t_menu (menuname,description) values (menu.menuname,menu.description)")
    @Options(useGeneratedKeys = true, keyProperty = "menu.id")
    int addMenu(@Param("menu") Menu menu);

    @Update("update t_menu t set t.menuname=menu.menuname and t.description=menu.description where t.id=menu.id")
    int update(@Param("menu") Menu menu);

    @Delete("delete from t_menu t where t.id=#{id}")
    int delete(Integer id);
}
