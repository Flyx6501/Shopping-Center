package com.service;

import com.dao.OrdersDao;
import com.mysql.jdbc.Connection;
import com.utils.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 增加订单
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/24 20:05
 **/
public class OrdersDaoImpl implements OrdersDao {

    @Override
    public boolean insertOrder(Connection c, int orderId, int commodityId, int commodityNum) {

    return true;
    }

    @Override
    public List<Object> selectOrderByuserName(Connection c, String userName) {
        List<Object> list = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            StringBuffer a=new StringBuffer();
            a.append("SELECT o.order_id,o.order_commodity_num,u.user_username,c.commodity_name,c.commodity_price FROM `order` o,`user` u,`commodity` c ");
           //String sql = "select o.order_id,o.order_commodity_num,u.user_username,c.commodity_name,c.commodity_price from `order` o,`user` u,`commodity` c where u.user_username=?";
            if (userName!=null && userName !=""){
                a.append("where u.user_username=? ");
            }
            ps=c.prepareStatement(String.valueOf(a));
            //ps = c.prepareStatement(sql);
            if (userName!=null && userName!=""){
                ps.setString(1, userName);
            }
            rs = ps.executeQuery();
           while (rs.next()) {
               int orderId = rs.getInt("o.order_id");
               Double commodityNum = rs.getDouble("o.order_commodity_num");
               userName = rs.getString("u.user_username");
               String commodityName = rs.getString("c.commodity_name");
               Double commodityPrice = rs.getDouble("c.commodity_price");

               list.add(orderId);
               list.add(commodityNum);
               list.add(userName);
               list.add(commodityName);
               list.add(commodityPrice);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
            JDBCUtil.closeResource(c,ps,rs);
        }
        return list;
    }

    @Override
    public List<Object> selectOrders(Connection c) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Object> objects = new ArrayList<>();
        try {

            String sql = "SELECT  *  FROM `commodity` c,`order` o ";
            ps = c.prepareStatement(sql);
             rs = ps.executeQuery();
            while (rs.next()) {
                Double commodityNum = rs.getDouble("o.order_commodity_num");
                String commodityName = rs.getString("c.commodity_name");
                Double commodityPrice = rs.getDouble("c.commodity_price");
                objects.add(commodityNum);
                objects.add(commodityName);
                objects.add(commodityPrice);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeResource(c,ps,rs);
        }
        return objects;
    }

    @Override
    public boolean deleteOrders(Connection c, String commodityName) throws SQLException {
        //TODO 删除功能语句尚且不太准确
        String sql = "DELETE  FROM `order` o,`commodity` c WHERE c.commodity_name=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,commodityName);
        int i = ps.executeUpdate();
        if (i>=1){
            return true;
        }
        return false;
    }


}