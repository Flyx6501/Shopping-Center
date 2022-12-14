package com.service;

import com.dao.CarDao;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.utils.DBHeper;

import java.sql.PreparedStatement;
import java.util.*;

/**
 * @author Qgs123
 * @version 1.0
 * @date 2022/12/1 14:52
 **/
public class CarDaoImpl implements CarDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    private int rs2;
    /** Map
     * @param userName  用户id
     * @return com.bean.Car
     * @author Qgs123
     * @date 2022/12/01 14:55
     **/
    @Override
    public List<Map> getCarByUserName(String userName) {

        List<Map> car =new LinkedList<>();
        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" select a.*,b.commodity_price from  car a,commodity b,user c");
            sb.append(" where a.car_commodity_id = b.commodity_id ");
            sb.append(" and c.user_id = a.car_user_id ");
            if(userName != null && userName != "") {
                sb.append(" and c.user_username = ? ");
            }
            ps=con.prepareStatement(String.valueOf(sb));
            if(userName != null && userName != "") {
                ps.setString(1, userName);
            }
            rs=ps.executeQuery();
            while (rs.next()){
                Integer car_id = rs.getInt(1);
                Integer commodity_id = rs.getInt(2);
                Integer user_id = rs.getInt(3);
                Integer commodity_num = rs.getInt(4);
                Double commodity_price = rs.getDouble(5);
                Map commodity = new HashMap<>();
                commodity.put("car_id", car_id);
                commodity.put("user_id", user_id);
                commodity.put("car_commodity_id", commodity_id);
                commodity.put("car_commodity_num", commodity_num);
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
    /** Map
     * @param commodityId  商品id
     * @return java.util.Map
     * @author Qgs123
     * @date 2022/12/04 11:24
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
    /** 更新商品
     * @param userId 用户id
     * @param commodityId 商品id
     * @param count 数量
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/01 14:56
     **/
    @Override
    public Integer updateCommodity(Integer carId,Integer userId,Integer commodityId,Integer count) {

        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" UPDATE  `car` ");
            sb.append(" set car_commodity_num = ? ");
            sb.append(" where car_user_id = ? ");
            sb.append(" and car_commodity_id = ? ");
            sb.append(" and car_id = ? ");
            ps=con.prepareStatement(String.valueOf(sb));
            ps.setInt(1, count);
            ps.setInt(2, userId);
            ps.setInt(3, commodityId);
            ps.setInt(4, carId);
            rs2=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHeper.getColes(con, ps, rs);
        }
        return rs2;
    }
    /** 删除购物车
     * @param userId
     * @param commodityId
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/01 14:56
     **/
    @Override
    public Integer deleteCommodity(Integer userId,Integer commodityId) {

        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" delete from `car` ");
            sb.append(" where car_user_id = ? ");
            sb.append(" and car_commodity_id = ? ");
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
    /** 添加商品
     * @param userId
     * @param commodityId
     * @param count
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/01 14:57
     **/
    @Override
    public Integer addCommodity(Integer userId,Integer commodityId,Integer count) {

        try {
            con= (Connection) DBHeper.getCon();
            StringBuffer sb = new StringBuffer();
            sb.append(" insert into `car` ");
            sb.append(" (car_id,car_commodity_id,car_user_id,car_commodity_num)");
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
    /** 购物车用户名找id
     * @param userName 用户名
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/01 14:57
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
}