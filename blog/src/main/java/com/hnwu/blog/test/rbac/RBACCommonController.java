package com.hnwu.blog.test.rbac;

import com.google.common.collect.Lists;
import com.hnwu.blog.rbac.menu.Menu;
import com.hnwu.blog.rbac.menu.service.MenuService;
import com.hnwu.blog.rbac.role.Role;
import com.hnwu.blog.rbac.role.service.RoleService;
import com.hnwu.blog.rbac.user.User;
import com.hnwu.blog.rbac.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴会楠 on 2018/1/2.
 */
@Controller
@RequestMapping("/RBACCommonController")
public class RBACCommonController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public String getUserById(){
        User user = userService.queryUserById(1);
        return user != null ? user.getUsername():"No Name Is Good Name!";
    }

    @RequestMapping(value = "/queryUsersByRoleId", method = RequestMethod.GET)
    @ResponseBody
    public List<User> queryUsersByRoleId(){
        List<User> users = userService.queryUsersByRoleId(1);
        return users;
    }

    @RequestMapping(value = "/getRolesByUserId", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getRolesByUserId(){
        List<Role> roles = roleService.getRolesByUserId(2);
        return roles;
    }

    @RequestMapping(value = "/queryRolesByMenuId", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> queryRolesByMenuId(){
        List<Role> roles = roleService.queryRolesByMenuId(1);
        return roles;
    }

    @RequestMapping(value = "/queryRoleById", method = RequestMethod.GET)
    @ResponseBody
    public Role queryRoleById(){
        Role role = roleService.queryRoleById(1);
        return role;
    }

    /**
     * get all menu list
     */
    @RequestMapping("/queryMenus")
    @ResponseBody
    public List<Menu> queryMenus(){
        return menuService.queryMenus();
    }

    /**
     * get menus by roleId
     */
    @RequestMapping("/queryMenusByRoleId")
    @ResponseBody
    public List<Menu> queryMenusByRoleId(@RequestParam("RoleId") Integer roleId){
        return menuService.queryMenusByRoleId(roleId);
    }

    /**
     * get menus by userId
     */
    @RequestMapping("/queryMenusByUserId")
    @ResponseBody
    public List<Menu> queryMenusByUserId(@RequestParam("UserId") Integer userId){
        return menuService.queryMenusByUserId(userId);
    }

    /**
     * get menus by userId
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestParam("UserName") String userName, @RequestParam("Description") String description){
        User user = new User();
        user.setUsername(userName);
        user.setDescription(description);
        return userService.saveOrUpdate(user);
    }


    public static void main(String[] args){
        List<String> list1 = Lists.newArrayList("J","Q","K");
        List<String> list2 = Lists.newArrayList("11","12","13");

        List<String> list3 = new ArrayList<String>();

        list1.stream().map(s -> s + ":END").forEach(s -> System.out.println(s));
        list1.addAll(list2);
        list1.stream().map(s -> s + ":END").forEach(s -> System.out.println(s));
    }
}
