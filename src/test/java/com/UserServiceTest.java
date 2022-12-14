package com;

import com.mysql.jdbc.Connection;
import com.utils.JDBCUtil;
import org.junit.Test;
import com.service.UserDaoImpl;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/11/7 15:17
 **/

public class UserServiceTest {
    /**
     * 用户登录方法测试
     * @author l666888999
     * @date 2022/11/08 17:41
     **/
    @Test
    public void registerNameTest() {
        UserDaoImpl userService = new UserDaoImpl();
        //  userService.check(Connection c,1,22);
        Connection c = null;
        try {
            c = (Connection) JDBCUtil.getConnection();
            userService.insertUser(c, "123132","141","ll","ljy");
            System.out.println("123");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用户注册方法测试
     * @author l666888999
     * @date 2022/11/08 17:41
     **/
    @Test
    public void searchNameTest() {
        UserDaoImpl userService = new UserDaoImpl();
        Connection c = null;

        try {
            c = (Connection) JDBCUtil.getConnection();
            boolean flag = userService.getUserByUsernameAndPassword(c, "123456", "123");
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
