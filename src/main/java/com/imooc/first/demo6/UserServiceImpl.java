package com.imooc.first.demo6;

import com.imooc.first.demo1.UserService;

/**
 * Created by jt on 2017/10/8.
 */
public class UserServiceImpl implements UserService {

    // 添加属性:
    private String name;

    public void sayHello() {
        System.out.println("Hello Spring" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
