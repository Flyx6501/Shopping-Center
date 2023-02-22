package com.dao;

import com.bean.Commodity;
import com.bean.Orders;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/** 订单
 * @author Qgs123
 * @date 2023/02/21 16:25
 **/
public interface OrdersDao {
  /** 获取订单的用户信息
       * @param userName  用户名
       * @return java.util.List<java.util.Map>
   * @author Qgs123
          * @date 2023/02/21 11:31
          **/
   List<Map> getOrderByUserName(String userName);
   /** 用户订单详情
    * @param userId 用户id
    * @return java.util.List<com.bean.Commodity>
    * @author Qgs123
    * @date 2023/02/21 15:16
    **/
    List<Commodity> getOrderCommodityList(Integer userId);
    /** 获取全部订单列表
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2023/02/21 16:29
     **/
    List<Map> getAllOrderList(String userName);
   /** Map
        * @param commodityId  商品id
        * @return java.util.Map
    * @author Qgs123
           * @date 2023/02/21 11:32
           **/
    Map getCommodityById(String commodityId);
/** 删除订单
     * @param userId 用户id
     * @param commodityId 商品id
     * @return java.lang.Integer
 * @author Qgs123
        * @date 2023/02/21 11:33
        **/
   Integer deleteCommodity(Integer userId,Integer commodityId);
   /** 订单根据用户用查找用户id
        * @param userName  用户名
        * @return java.lang.Integer
    * @author Qgs123
           * @date 2023/02/21 11:35
           **/
    Integer getUserIdByName(String userName);
/** 添加订单
     * @param userId
     * @param commodityId
     * @param count
     * @return java.lang.Integer
 * @author Qgs123
        * @date 2023/02/21 11:43
        **/
    Integer addCommodity(Integer userId,Integer commodityId,Integer count);

}