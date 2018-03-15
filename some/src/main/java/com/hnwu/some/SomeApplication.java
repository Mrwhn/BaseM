package com.hnwu.some;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 吴会楠 on 2017/11/30.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SomeApplication.class, args);
    }
}
