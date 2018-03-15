package com.hnwu.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴会楠 on 2017/11/30.
 */

@Service
public class PersonHystrixService {
    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave")
    public String save(){
        return personService.hello();
    }

    public String fallbackSave(){
        return ("Save exception!");
    }
}
