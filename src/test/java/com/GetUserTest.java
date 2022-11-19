package com;

import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 查询用户测试类
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/16 9:18
 **/
public class GetUserTest {
    @Test
    public void getUserByUserName(){
        Connection c=null;
        try {
            c = JDBCUtil.getConnection();
            ManagerDaoImpl test = new ManagerDaoImpl();
            test.getUserByUserName((com.mysql.jdbc.Connection) c,"3");
            //System.out.println(1);
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