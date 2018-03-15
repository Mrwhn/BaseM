package com.hnwu.some.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 吴会楠 on 2017/11/30.
 */
@RestController
public class SomeController {
    @Value("${my.message}")
    private String message;

    @RequestMapping(value = "/getSome")
    public String getSome(){
        return  message;
    }
}
