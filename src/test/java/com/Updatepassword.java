package com;

import com.service.UserDaoImpl;
import com.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/11/17 9:40
 **/
public class Updatepassword {
    @Test
    public void searchpassword(){
        Connection c = null;
        try {


           c = JDBCUtil.getConnection();
          UserDaoImpl test = new UserDaoImpl();
          test.searchUserByPassword((com.mysql.jdbc.Connection) c, "123456","123321");

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
    public void updatePassword(){
        Connection c=null;
        try {


           c = JDBCUtil.getConnection();
           UserDaoImpl test = new UserDaoImpl();
           test.updateUserByPassword((com.mysql.jdbc.Connection) c, "123456", "123456");

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