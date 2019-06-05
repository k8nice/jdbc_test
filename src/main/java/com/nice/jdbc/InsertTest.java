package com.nice.jdbc;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 原生jdbc插入
 * @author ningh
 */
public class InsertTest {

    /**
     * 连接信息
     */
    private final static String USERNAME="root";
    private final static String PASSWORD="nice";
    private final static String URL= "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获得连接
             connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql = "insert into nice_test values(5,'Avro')";
//            PreparedStatement statement = connection.prepareStatement(sql);
            //加载sql
            statement = connection.prepareStatement(sql);
            //执行sql语句
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭连接
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
