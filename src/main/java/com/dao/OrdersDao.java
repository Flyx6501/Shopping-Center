package com.dao;

import com.bean.Orders;
import com.mysql.jdbc.Connection;

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
    List<Object> selectOrderByuserName(Connection c, String userName);
}