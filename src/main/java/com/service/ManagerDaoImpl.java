package com.service;

import com.dao.ManagerDao;
import com.mysql.jdbc.Connection;
import com.utils.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** 管理员类的Service
 * @author l666888999
 * @date 2022/11/08 19:20
 **/
public class ManagerDaoImpl implements ManagerDao {
    @Override
    public boolean searchName(Connection c, int manageId, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT mange_id,password FROM `manage` WHERE  mange_id=? and password=? ";
            ps = c.prepareStatement(sql);
            ps.setInt(1, manageId);
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
    public boolean registerName(Connection c,int manageId, String password, String userName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO manage(password,mange_username) VALUES (?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2,userName);
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