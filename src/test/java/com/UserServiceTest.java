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
   /** TODO   
    * @author l666888999
    * @date  2022/11/08 15:40
    **/
    @Test
    public void registerNametest()  {
        UserDaoImpl userService = new UserDaoImpl();
      //  userService.check(Connection c,1,22);
     Connection c=null;
        try {
            c= (Connection) JDBCUtil.getConnection();
            userService.registerName(c, 6,"12233124124");
            System.out.println("123");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                c.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

   /** TODO   
    * @author 
    * @date  
    **/
    @Test
    public void searchName()  {
        UserDaoImpl userService = new UserDaoImpl();
        Connection c=null;
        try {


            c=(Connection) JDBCUtil.getConnection();
            userService.searchName(c, 3, "123");
            System.out.println("123");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {


                c.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
