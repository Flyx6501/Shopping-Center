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
    public boolean searchName(Connection c, int userId, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT user_id,user_password FROM `user` WHERE  user_id=? and user_password=? ";
            ps = c.prepareStatement(sql);
            ps.setInt(1, userId);
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
    public boolean registerName(Connection c, int userId, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO user(user_name,nickname,user_password,user_password,email) VALUES (?,?,?,?,?)";
            ps = c.prepareStatement(sql);
            //ps.setInt(1,userId);
            ps.setString(1, password);
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.setString(5, "");

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
