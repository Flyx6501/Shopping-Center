package com;

import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 更新用户信息
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/12 14:25
 **/
public class UpdateUserTest {

    @Test
    public void UpdateUsers() {
        Connection c = null;
        try {
            ManagerDaoImpl test = new ManagerDaoImpl();
            c = JDBCUtil.getConnection();
            boolean flag = test.updateUserByUserId((com.mysql.jdbc.Connection) c, "ss", "123", "6161@qq.com", "ll", "33");
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}