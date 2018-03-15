package com.hnwu.blog.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by 吴会楠 on 2017/12/8.
 */
@Aspect
@Component
public class CommonAspect {
    private Logger logger = LoggerFactory.getLogger(CommonAspect.class);

    @Pointcut("execution(* com.hnwu.blog.*.dao.impl.*.*save*(..))")
    public void savePoint(){}

    @Pointcut("execution(* com.hnwu.blog.*.dao.impl.*.*query*(..))")
    public void queryPoint(){}

    @Pointcut("execution(* com.hnwu.blog.*.controller.*.*query*(..))")
    public void queryController(){}

    @Before("savePoint()")
     public void beforeSave(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println(method.getName());

    }

    @Before("queryController()")
    public void beforeQuery(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        logger.info("个人信息查询：" + joinPoint.getArgs());
        Object[] objects = joinPoint.getArgs();
        for (int i = 0; i<objects.length; i++){
            logger.warn(objects[i] + "");
        }
        Method method = signature.getMethod();
        System.out.println(method.getName());

    }
}
