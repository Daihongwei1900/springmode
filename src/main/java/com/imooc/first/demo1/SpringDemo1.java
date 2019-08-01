package com.imooc.first.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jt
 */
public class SpringDemo1 {

    @Test
    /**
     * 传统方式开发
     */
    public void demo1(){
        // UserService userService = new UserServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        // 设置属性:
        userService.setName("张三");
        userService.sayHello();
    }
    @Test
    public void demo2(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }


}
