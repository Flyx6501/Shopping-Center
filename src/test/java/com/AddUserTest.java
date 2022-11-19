package com;

import com.mysql.jdbc.Connection;
import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.SQLException;

/**
 * 增加用户
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/19 22:07
 **/
public class AddUserTest {
    @Test
    public void addUser(){
        Connection c=null;
        try {


            c = (Connection) JDBCUtil.getConnection();
            ManagerDaoImpl test = new ManagerDaoImpl();
            test.addUser(c, "ll", "1410@qq.com", "weifang", "xiaoyong");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}