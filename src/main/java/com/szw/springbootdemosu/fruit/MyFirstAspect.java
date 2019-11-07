package com.szw.springbootdemosu.fruit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author suzhiwei
 * @Date 2019/11/07
 * @Describe
 */
@Aspect
@Component
public class MyFirstAspect {

    @Pointcut("@annotation(FruitName)")
    public void annotationPointcut() {
    }
    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        FruitName annotation = method.getAnnotation(FruitName.class);
        String value = annotation.value();
        System.out.println("准备"+value);
    }

    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        FruitName annotation = method.getAnnotation(FruitName.class);
        String value = annotation.value();
        System.out.println("结束"+value);
    }
}