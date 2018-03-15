package com.hnwu.shiro.test;

import com.hnwu.shiro.rbac.user.User;
import com.hnwu.shiro.rbac.user.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 吴会楠 on 2018/2/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user){
        System.out.println("LANG");
        ModelAndView mv = new ModelAndView();

        System.out.println(user.toString());
        user.setPassword(new Md5Hash(user.getPassword(), user.getUsername()).toString());
        System.out.println(user.toString());
        try{
            userService.saveOrUpdate(user);
        }catch(Exception e){
            System.out.println(e);
        }
        mv.setViewName("user/userInfo");
        return mv;
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ModelAndView userInfo(){
        ModelAndView mv = new ModelAndView();
        User user = new User();

        mv.addObject("user", user);
        mv.setViewName("user/userInfoAdd");
        return mv;
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.DELETE)
    public ModelAndView delUser(){
        ModelAndView mv = new ModelAndView();
        User user = new User();
        mv.addObject("user", user);
        mv.setViewName("user/userInfoDel");
        return mv;
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ModelAndView role(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("rbac/user/userRoleAdd");
        return mv;
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ModelAndView addRole(@RequestParam("userid") String userId, @RequestParam("roleid") String roleId){

        int result = userService.saveUserRole(userId, roleId);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("rbac/user/userRoleAdd");
        return mv;
    }

}
