package com;

import com.mysql.jdbc.Connection;
import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.SQLException;

/**
 * 更新用户信息
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/22 15:55
 **/
public class UpdateManagerTest {
    @Test
    public void updateManagerTest(){
        Connection c=null;
        try {
         c = (Connection) JDBCUtil.getConnection();
            ManagerDaoImpl test = new ManagerDaoImpl();
            test.updateManagerById(c, "33", "ss", "22@qq", "sss", 48);
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