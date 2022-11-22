package com;

import com.mysql.jdbc.Connection;
import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.SQLException;

/**
 * 删除用户
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/21 22:08
 **/
public class DeleteUserById {
    @Test
    public void deleteUserByIdTest() throws SQLException {
        Connection c=null;
        try {
             c = (Connection) JDBCUtil.getConnection();
            ManagerDaoImpl test = new ManagerDaoImpl();
            test.deleteUserById(c, 3);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            c.close();
        }

    }
}