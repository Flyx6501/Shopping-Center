package com.service;


import com.bean.Commodity;
import com.dao.OrdersDao;
import com.mysql.jdbc.Connection;
import com.utils.DBHeper;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;

/** 订单接口
 * @author Qgs123
 * @date 2023/02/21 16:25
 **/
public class OrdersDaoImpl implements OrdersDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rs2;
    /** 获取订单的用户信息
     * @param userName  用户名
         * @return java.util.List<java.util.Map>
     * @author Qgs123
            * @date 2023/02/21 16:21
            **/
    @Override
    public List<Map> getOrderByUserName(String userName) {

        List<Map> car =new LinkedList<>();
        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" select a.*,b.commodity_price from  `order` a,`commodity` b,`user` c");
            sb.append(" where a.order_commodity_id = b.commodity_id ");
            sb.append(" and c.user_id = a.order_user_id ");
            if(userName != null && userName != "") {
                sb.append(" and c.user_username = ? ");
            }
            ps=con.prepareStatement(String.valueOf(sb));
            if(userName != null && userName != "") {
                ps.setString(1, userName);
            }
            rs=ps.executeQuery();
            while (rs.next()){
                Integer order_id = rs.getInt(1);
                Integer commodity_id = rs.getInt(2);
                Integer user_id = rs.getInt(3);
                Integer commodity_num = rs.getInt(4);
                Double commodity_price = rs.getDouble(5);
                Map commodity = new HashMap<>();
                commodity.put("order_id", order_id);
                commodity.put("user_id", user_id);
                commodity.put("order_commodity_id", commodity_id);
                commodity.put("order_commodity_num", commodity_num);
                commodity.put("commodity_price", commodity_price);
                car.add(commodity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return car;
    }
    /**  Map
     * @param commodityId  商品id
         * @return java.util.Map
     * @author Qgs123
            * @date 2023/02/21 16:22
            **/
    @Override
    public Map getCommodityById(String commodityId) {

        Map commodity = new HashMap<>();
        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" select a.* from  commodity ");
            if(commodityId != null && commodityId != "") {
                sb.append(" and commodityId = ? ");
            }
            ps=con.prepareStatement(String.valueOf(sb));
            if(commodityId != null && commodityId != "") {
                ps.setInt(1, Integer.parseInt(commodityId));
            }
            rs=ps.executeQuery();
            while (rs.next()){
                Integer commodity_id = rs.getInt(1);
                String commodity_name = rs.getString(2);
                Double commodity_price = rs.getDouble(3);

                commodity.put("commodity_id", commodity_id);
                commodity.put("commodity_name", commodity_name);
                commodity.put("commodity_price", commodity_price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return commodity;
    }
    /** 删除订单
     * @param userId 用户id
         * @param commodityId
         * @return java.lang.Integer
     * @author Qgs123
            * @date 2023/02/21 16:23
            **/
    @Override
    public Integer deleteCommodity(Integer userId,Integer commodityId) {

        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" delete from `order` ");
            sb.append(" where order_user_id = ? ");
            sb.append(" and order_commodity_id = ? ");
            ps=con.prepareStatement(String.valueOf(sb));
            ps.setInt(1, userId);
            ps.setInt(2, commodityId);
            rs2=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return rs2;
    }
    /** 订单根据用户用查找用户id
     * @param userName  用户名
         * @return java.lang.Integer
     * @author Qgs123
            * @date 2023/02/21 16:23
            **/
    @Override
    public Integer getUserIdByName(String userName) {
        Integer userId = 0;
        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append("   select user_id from user   ");
            sb.append("   where user_username = ? ");
            ps=con.prepareStatement(String.valueOf(sb));
            ps.setString(1, userName);
            rs=ps.executeQuery();
            while (rs.next()){

                userId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return userId;
    }
    /** 添加订单
         * @param userId 用户id
         * @param commodityId  商品id
         * @param count 商品数量
         * @return java.lang.Integer
     * @author Qgs123
            * @date 2023/02/21 16:24
            **/
    @Override
    public Integer addCommodity(Integer userId,Integer commodityId,Integer count) {

        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" insert into `order` ");
            sb.append(" (order_id,order_commodity_id,order_user_id,order_commodity_num)");
            sb.append(" values(?,?,?,?)");
            ps=con.prepareStatement(String.valueOf(sb));
            Date date =new Date();
            String car_id = String.valueOf(date.getMonth()+ date.getDay()+ date.getHours() +date.getMinutes()+date.getSeconds());
            ps.setInt(1, Integer.parseInt(car_id));
            ps.setInt(2, commodityId);
            ps.setInt(3, userId);
            ps.setInt(4, count);
            rs2=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return rs2;
    }
    /** 用户订单详情
     * @param userId 用户id
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2023/02/21 16:29
     **/
    @Override
    public List<Commodity> getOrderCommodityList(Integer userId) {
        List<Commodity> list=new ArrayList<Commodity>();
        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer ss=new StringBuffer();
            ss.append(" select a.*, b.order_commodity_num from `commodity` a,`order` b ");
            ss.append(" where a.commodity_id = b.order_commodity_id ");
            if(userId!=null && userId !=0){
                ss.append(" and b.order_user_id =? ");
            }
            ps=con.prepareStatement(String.valueOf(ss));
            if (userId!=null && userId !=0){
                ps.setInt(1,userId);
            }
            rs=ps.executeQuery();
            while (rs.next()){
                Commodity g=new Commodity();
                g.setCommodityId(rs.getInt(1));
                g.setCommodityName(rs.getString(2));
                g.setCommodityPrice(rs.getDouble(3));
                g.setCommodityStock(rs.getInt(4));
                g.setCommodityPhoto(rs.getString(5));
                g.setCommodityInformation(rs.getString(6));
                g.setCommodityComment(rs.getString(7));
                g.setCommodityNum(rs.getInt(8));
                list.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return list;
    }
    /** 获取全部订单
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2023/02/21 16:31
     **/
    @Override
    public List<Map> getAllOrderList(String userName){
        List<Map> list=new ArrayList<>();
        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer ss=new StringBuffer();
            ss.append(" select b.order_id,c.user_username,a.commodity_name, b.order_commodity_num,a.commodity_price from `commodity` a,`order` b,`user` c");
            ss.append(" where a.commodity_id = b.order_commodity_id and b.order_user_id = c.user_id ");
            if(userName!=null && userName !=""){
                ss.append(" and c.user_username =? ");
            }
            ps=con.prepareStatement(String.valueOf(ss));
            if (userName!=null && userName !=""){
                ps.setString(1,userName);
            }
            rs=ps.executeQuery();
            while (rs.next()){
            Integer orderId=rs.getInt(1);
            String userUserName=rs.getString(2);
            String commodityName=rs.getString(3);
            Integer commodityNum=rs.getInt(4);
            Double commodityPrice=rs.getDouble(5);
            Map commodity=new HashMap<>();
            commodity.put("orderId",orderId);
            commodity.put("userName",userUserName);
            commodity.put("commodityName",commodityName);
            commodity.put("commodityNumber",commodityNum);
            commodity.put("commodityPrice",commodityPrice);
                list.add(commodity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return list;
    }
}