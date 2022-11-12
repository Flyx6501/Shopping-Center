package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 23130
 * @version 1.0
 * @date 2022/11/12 9:53
 **/
public class DBHeper {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static final String URL="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    public static Connection getCon() {
        try {
            return	DriverManager.getConnection(URL,"root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getColes(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if(con!=null&&!con.isClosed())con.close();
            if(ps!=null)ps.close();
            if(rs!=null)rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}