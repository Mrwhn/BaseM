package com.hnwu.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by 吴会楠 on 2017/11/30.
 */
@Service
public class SomeHystrixService {
    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome(){
        return restTemplate.getForObject("http://SOME/getSome", String.class);
    }

    public String fallbackSome(){
        return "Some Exception!";
    }
}
