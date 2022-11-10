package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类
 *
 * @author l666888999
 * @date 2022/11/08 21:26
 **/
public class JDBCUtil {
    /**
     * 获取 JDBC 连接
     *
     * @return java.sql.Connection
     * @author l666888999
     * @date 2022/11/08 15:45
     **/
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //读取配置文件基本信息
        Properties pros = new Properties();
        Properties file = new Properties();
        //pros.load(new FileInputStream(new File("F:\\xianmu\\Shopping-Center\\src\\main\\resources\\jdbc.properties")));
        pros.load(new FileInputStream(new File("I:\\Workspace\\Java\\Test\\Shopping-Center\\src\\main\\resources\\jdbc.properties")));
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取链接
        Connection c = DriverManager.getConnection(url, user, password);

        return c;
    }

    /**
     * 关闭链接
     *
     * @param c  进行数据库链接
     * @param ps 预编译数据库
     * @param rs 获取数据集
     * @author l666888999
     * @date 2022/11/08 15:45
     **/
    public static void closeResource(Connection c, Statement ps, ResultSet rs) {
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

    /**
     * 关闭链接
     *
     * @param c  进行数据库链接
     * @param ps 预编译数据库
     * @author l666888999
     * @date 2022/11/08 15:45
     **/
    public static void closeResource(Connection c, Statement ps) {
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
    }
}


