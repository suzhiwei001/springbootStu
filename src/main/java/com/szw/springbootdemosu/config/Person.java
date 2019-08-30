package com.szw.springbootdemosu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//将类添加进容器
//把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>
@Component
//告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private int age;

    @Value("${person.name}")
    private String nameT;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameT() {
        return nameT;
    }

    public void setNameT(String nameT) {
        this.nameT = nameT;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nameT='" + nameT + '\'' +
                '}';
    }
}
