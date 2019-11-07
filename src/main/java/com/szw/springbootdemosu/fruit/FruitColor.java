package com.szw.springbootdemosu.fruit;

import java.lang.annotation.*;

/**
 * @author suzhiwei
 * @Date 2019/11/07
 * @Describe
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color{BLUE,RED,GREEN};

    Color fruitColor() default Color.BLUE;
}
