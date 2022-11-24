package com;

import com.bean.User;
import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
            test.getUserByUserName((com.mysql.jdbc.Connection) c,"3",1,2);
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
    @Test
    public void getUserByUserNames(){
        Connection c=null;
        try {
            c = JDBCUtil.getConnection();
            ManagerDaoImpl test = new ManagerDaoImpl();
            List<User> lists = test.getUserByUserNames((com.mysql.jdbc.Connection) c, "33");
            System.out.println(lists);
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
   @Test
    public void getAll(){
        Connection c=null;
        try {
            c = JDBCUtil.getConnection();
            ManagerDaoImpl test = new ManagerDaoImpl();
            List<User> lists = test.selectUser((com.mysql.jdbc.Connection) c);
            System.out.println(lists);
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