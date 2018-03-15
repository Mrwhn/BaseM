package com.hnwu.ui.controller;

import com.hnwu.ui.service.SomeHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 吴会楠 on 2017/12/1.
 */
@Controller
public class HelloController {

    @Autowired
    SomeHystrixService someHystrixService;

    @RequestMapping(value = "/showHello", method = RequestMethod.GET)
    public String showHello(){
        return "Hello";
    }
}
