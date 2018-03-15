package com.hnwu.ui.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 吴会楠 on 2017/11/30.
 */
@FeignClient(name = "server")
public interface PersonService {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();

}
