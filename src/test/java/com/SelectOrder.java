package com;

import com.mysql.jdbc.Connection;
import com.service.OrdersDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/11/27 20:59
 **/
public class SelectOrder {
    @Test
    public void selectOrder(){
        Connection c=null;
        try {
             c = (Connection) JDBCUtil.getConnection();
            OrdersDaoImpl test = new OrdersDaoImpl();
            List<Object> select = test.selectOrderByuserName(c, "123456");
           // System.out.println(select);
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