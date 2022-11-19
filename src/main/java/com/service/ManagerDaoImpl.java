package com.service;
import com.bean.User;
import com.dao.ManagerDao;
import com.mysql.jdbc.Connection;
import com.utils.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** 管理员类的Service
 * @author l666888999
 * @date 2022/11/08 19:20
 **/
public class ManagerDaoImpl implements ManagerDao {
    @Override
    public boolean searchName(Connection c, String manageName , String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT mange_username,password FROM `manage` WHERE  mange_username=? and password=? ";
            ps = c.prepareStatement(sql);
            ps.setString(1, manageName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
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
    public boolean registerName(Connection c, String password, String userName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO manage(password,mange_username) VALUES (?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2,userName);
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

    @Override
    public List<User> getUserByUserName(Connection c, String userName) {
        List<User> list= new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "SELECT user_id,user_username,email,address,nickname FROM user WHERE user_username=?";
             ps = c.prepareStatement(sql);
            ps.setString(1, userName);
             rs = ps.executeQuery();
            while (rs.next()) {
                User  user = new User();
                user.setUseId(rs.getInt("user_id"));
                user.setUserUsername(rs.getString("user_username"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setNickname(rs.getString("nickname"));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(c,ps,rs);
        }
    return list;
    }

    @Override
    public boolean addUser(Connection c, String userName, String email, String address, String nickName) {

        PreparedStatement ps=null;
        try {
            String sql = "INSERT INTO user(user_username,email,address,nickname) VALUES (?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, nickName);
            int i = ps.executeUpdate();
            if (i >= 1) {
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