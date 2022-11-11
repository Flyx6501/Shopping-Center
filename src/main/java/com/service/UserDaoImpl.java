package com.service;

import com.dao.UserDao;
import com.mysql.jdbc.Connection;
import com.utils.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户类 User 的 Service
 *
 * @author l66888999
 * @version 1.0
 * @date 2022/11/07 22:37
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean getUserByUsernameAndPassword(Connection c, String userName, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT user_username,user_password FROM `user` WHERE  user_username=? and user_password=?";
            ps = c.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(c, ps, rs);
        }
        return false;
    }

    @Override
    public boolean insertUser(Connection c, String userName, String password, String email, String nickName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO user(user_username,user_password,email,nickname) VALUES (?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4,nickName);
            int rs1 = ps.executeUpdate();
            if (rs1 >= 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(c, ps, rs);
        }
        return false;
    }

    @Override
    public boolean findUserByUserName(Connection c, String userName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
       try {
           String sql = "SELECT user_username FROM `user` WHERE user_username=?";
           ps = c.prepareStatement(sql);
           ps.setString(1, userName);
           rs = ps.executeQuery();
           while (rs.next()) {
               System.out.println("该用户已经注册过");
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           JDBCUtil.closeResource(c, ps, rs);
       }
       return false;
    }

    @Override
    public boolean updateUserByUserId(Connection c, String userName, String password, String email, String nickName, int userId) {
        PreparedStatement ps=null;
        try {
            String sql = "UPDATE `user` SET user_username=?,user_password=?,email=?,nickname=? WHERE user_id=?";
             ps = c.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, nickName);
            ps.setInt(5,userId);
            int rs1=ps.executeUpdate();
            if (rs1>=1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(c,ps);
        }
        return false;
    }
}
