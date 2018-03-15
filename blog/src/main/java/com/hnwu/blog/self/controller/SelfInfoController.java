package com.hnwu.blog.self.controller;

import com.hnwu.blog.self.entity.SelfInfo;
import com.hnwu.blog.self.service.SelfInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 吴会楠 on 2017/12/5.
 */
@Controller
@RequestMapping(value = "/self")
public class SelfInfoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SelfInfoService selfInfoService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView selfInfoMain(@ModelAttribute("info") SelfInfo selfInfo){
        //System.out.println("ATTR" + (selfInfoAttr != null ?selfInfoAttr.getUsername():"共产主义万岁"));
        ModelAndView mv = new ModelAndView();
        //个人信息获取
        //SelfInfo selfInfo = selfInfoService.queryByName("Jack");
        selfInfo.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        mv.addObject("info", selfInfo);

        //个人信息列表
        List<String> bookList = new ArrayList<String>();
        bookList.add("Spring Boot实战详解");
        bookList.add("Java虚拟机原理解析");
        bookList.add("解忧杂货铺读后感");
        mv.addObject("bookList", bookList);
        mv.setViewName("self/SelfMain");
        return mv;
    }

   /* @RequestMapping(value = "/logon", method = RequestMethod.GET)
    public ModelAndView logon(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("self/Login");
        return mv;
    }*/

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String saveSelf(@ModelAttribute("form") SelfInfo selfInfo){
        int result = selfInfoService.saveSelf(selfInfo);
        System.out.println("保存的结果" + result);
        return "保存" + selfInfo.getUsername() + "成功";
    }

    @RequestMapping(value = "/logonSelf", method = RequestMethod.GET)
    public ModelAndView logonSelf(@ModelAttribute("form") SelfInfo selfInfo, RedirectAttributes attr){
        ModelAndView mv = new ModelAndView();
        SelfInfo selfInfoDB = selfInfoService.queryByName(selfInfo.getUsername());
        //查询数据与录入的数据相同，登陆成功
        if(selfInfoDB != null &&selfInfoDB.getPassword().equals(selfInfo.getPassword())){
            attr.addFlashAttribute("info", selfInfoDB);
            mv.setViewName("redirect:/self/main");
        }else{ //登陆失败
            mv.setViewName("forward:/self/logon");
        }
        return mv;
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String queryTestException(){
        logger.debug("1");
        logger.info("2");
        logger.warn("3");
        logger.error("4");
        logger.trace("0");
        throw new RuntimeException("Miss大小姐");
    }

    @RequestMapping(value = "/getSelfInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getSelfInfo(){
        return selfInfoService.getSelfInfo(1).getUsername();
    }

    /**
     * Mybatis 配置文件版本
     * @return
     */
    @RequestMapping(value = "/getSelf", method = RequestMethod.GET)
    @ResponseBody
    public String getSelf(){
        System.out.println("Controller");
        return selfInfoService.getSelf(3).getUsername();
    }


    @Value("${datasource.url}")
    private String message;
    @RequestMapping(value = "/getConfigValue", method = RequestMethod.GET)
    @ResponseBody
    public String getConfigValue(){
        return message;
    }
}
