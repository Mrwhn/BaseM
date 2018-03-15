package com.hnwu.ui.controller;

import com.hnwu.ui.service.PersonHystrixService;
import com.hnwu.ui.service.SomeHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 吴会楠 on 2017/11/30.
 */
@RestController
public class UiController {

    @Autowired
    PersonHystrixService personHystrixService;

    @Autowired
    SomeHystrixService someHystrixService;

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public String get1(){
       return ("1: " + personHystrixService.save());
    }

    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    public String get2(){
        return ("2: " + someHystrixService.getSome());
    }
}
