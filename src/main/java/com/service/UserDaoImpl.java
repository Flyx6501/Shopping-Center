package com.service;

import com.dao.UserDao;
import com.mysql.jdbc.Connection;
import com.utils.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public void check(Connection c, int userId, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT user_id,password FROM user WHERE use_id=? password=?";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int user = rs.getInt(1);
                String passwords = (String) rs.getObject(2);
                if (password.equals(passwords)) {
                    getUser(c,userId);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(c, ps, rs);
        }
    }

    @Override
    public void getUser(Connection c, int user_id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user where use_id=?";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            int user = rs.getInt(1);

            String passwords = (String) rs.getObject(2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResource(c, ps, rs);
        }
    }
}
