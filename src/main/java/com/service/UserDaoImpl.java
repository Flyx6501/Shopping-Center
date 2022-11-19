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
               return true;
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           JDBCUtil.closeResource(c, ps, rs);
       }
       return false;
    }

    @Override
    public boolean searchUserByPassword(Connection c,String userName,String passwords) {
        PreparedStatement ps=null;
        try {
            String sql = "SELECT user_username,user_password FROM `user` WHERE  user_username=? and user_password=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,passwords);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("选择的是该密码");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(c,ps);
        }
            return false;
    }

    @Override
    public boolean updateUserByPassword(Connection c, String password, String userName){
        PreparedStatement ps=null;
        try {
            String sql = "UPDATE `user` SET user_password=? WHERE user_username=?";
             ps = c.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, userName);
            int as = ps.executeUpdate();
            if (as >= 1) {
                System.out.println("更改成功");
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
