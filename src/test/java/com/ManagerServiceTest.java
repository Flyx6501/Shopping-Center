package com;

import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/11/8 16:34
 **/
public class ManagerServiceTest {
    /**
     * 管理员登录方法测试
     * @author l666888999
     * @date 2022/11/08 17:55
     **/
    @Test
    public void registerNameTest()  {
        ManagerDaoImpl managerService =new ManagerDaoImpl();
        Connection c=null;
        try {
            c = JDBCUtil.getConnection();
           managerService.registerName((com.mysql.jdbc.Connection) c, 1,"123", "manager");
           System.out.println("添加成功");
       }catch (Exception e){
           e.printStackTrace();
       }finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * 用户登录方法测试
     * @author l666888999
     * @date 2022/11/08 17:55
     **/
    @Test
    public void searchNameTest(){
        ManagerDaoImpl managerDao=new ManagerDaoImpl();
        Connection c=null;
        try {
            c = JDBCUtil.getConnection();
            managerDao.searchName((com.mysql.jdbc.Connection) c, "as", "123");
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                c.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
    }
}