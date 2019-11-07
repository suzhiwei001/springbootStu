package com.szw.springbootdemosu.fruit;

import java.lang.annotation.*;

/**
 * @author suzhiwei
 * @Date 2019/11/07
 * @Describe
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  FruitName {
    String value() default "";
}
