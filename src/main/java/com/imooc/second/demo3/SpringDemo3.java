package com.imooc.second.demo3;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {

    @Test
    public void demo1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");

        ProductService productService = (ProductService)applicationContext.getBean("productService");

        productService.save();
    }

}
