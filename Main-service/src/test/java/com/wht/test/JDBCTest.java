package com.wht.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    @Test
    public void testJdbc() throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.用户信息和url
        String url = "jdbc:mysql://114.116.9.68:3306/App?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String username="root";
        String password="19460";
        // 3.连接成功，数据库对象 Connection
        Connection connection = DriverManager.getConnection(url,username,password);
        //4.执行SQL对象Statement，执行SQL的对象
        Statement statement = connection.createStatement();
        //5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT * FROM users;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("id="+resultSet.getString("id"));
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
