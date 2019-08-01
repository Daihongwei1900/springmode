package com.imooc.transmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
   static final String dbDriver="com.mysql.jdbc.Driver";
   static final String dbUrl="jdbc:mysql://localhost:3306/test";
   static final String dbRoot="root";
   static final String dbPassword="root";
    //静态初始化块加载驱动
    static {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序");
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(dbUrl,dbRoot,dbPassword);
        } catch (SQLException e) {
            System.out.println("无法获取连接，是否数据库配置错误");
            e.printStackTrace();
        }
        return null;
    }
}

