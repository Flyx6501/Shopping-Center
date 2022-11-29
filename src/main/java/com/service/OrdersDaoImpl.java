package com.service;

import com.dao.OrdersDao;
import com.mysql.jdbc.Connection;
import com.utils.JDBCUtil;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
           String sql = "select o.order_id,o.order_commodity_num,u.user_username,c.commodity_name from `order` o,`user` u,`commodity` c where u.user_username=?";
           ps = c.prepareStatement(sql);
           ps.setString(1, userName);
            rs = ps.executeQuery();

           while (rs.next()) {
               int orderId = rs.getInt("o.order_id");
               Double commodityNum = rs.getDouble("o.order_commodity_num");
               userName = rs.getString("u.user_username");
               String commodityName = rs.getString("c.commodity_name");
               list.add(orderId);
               list.add(commodityNum);
               list.add(userName);
               list.add(commodityName);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
            JDBCUtil.closeResource(c,ps,rs);
        }
        return list;
    }


}