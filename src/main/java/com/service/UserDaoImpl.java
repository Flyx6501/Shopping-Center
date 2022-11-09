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
    public boolean searchName(Connection c, String userName, String password) {
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
    public boolean registerName(Connection c,String password, String email, String nickName, String userName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO user(user_username,nickname,user_password,email) VALUES (?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,nickName);
            ps.setString(3, password);
            ps.setString(4, email);

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
}
