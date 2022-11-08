package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //讀取配置文件基本信息
        Properties pros = new Properties();
        pros.load(new FileInputStream(new File("resources/jdbc.properties")));

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        System.out.println(driverClass);
        //2.加载驱动

        Class.forName(driverClass);

        //3.获取链接


        Connection c = DriverManager.getConnection(url, user, password);

        return c;
    }
    public static void closeResource (Connection c, Statement ps,ResultSet rs){
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (c != null) {
                c.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


