package com;

import com.service.UserDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/11/10 17:50
 **/
public class FindServiceTest {
    @Test
    public void findService() throws SQLException {
        Connection c = null;
        UserDaoImpl findService = new UserDaoImpl();
        try {
            c = JDBCUtil.getConnection();

            findService.findUserByUserName((com.mysql.jdbc.Connection) c, "22");
            // System.out.println("判断成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.close();
        }


    }
}