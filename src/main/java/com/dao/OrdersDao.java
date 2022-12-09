package com.dao;

import com.bean.Orders;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.List;

/**
 * 订单类的接口
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/24 20:02
 **/
public interface OrdersDao {
    /** 订单的插入
         * @param c
         * @param orderId
         * @param commodityId
         * @param commodityNum
         * @return boolean
     * @author l666888999
     * @date 2022/11/27 21:44
     **/
    boolean insertOrder(Connection c, int orderId, int commodityId, int commodityNum);
    /** 通过用户名选择订单
         * @param c
         * @param userName
         * @return java.util.List<java.lang.Object>
     * @author l666888999
     * @date 2022/12/06 21:41
     **/
    List<Object> selectOrderByuserName(Connection c, String userName);
    /** 进行订单的删除
         * @param c
         * @return java.util.List<java.lang.Object>
     * @author l666888999
     * @date 2022/12/06 21:42
     **/
    List<Object> selectOrders(Connection c);
    /** 进行订单的删除
         * @param c
         * @param commodityName
         * @return boolean
     * @author l666888999
     * @date 2022/12/06 22:09
     **/
    boolean deleteOrders(Connection c,String commodityName) throws SQLException;

}