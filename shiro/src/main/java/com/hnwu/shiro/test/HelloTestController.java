package com.hnwu.shiro.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 吴会楠 on 2018/1/31.
 */
@Controller
public class HelloTestController {

    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }
    public static void main(String[] args) {
        String password="1234";

        System.out.println(HelloTestController.md5(password, "123"));
    }


}
