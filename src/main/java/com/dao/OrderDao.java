package com.dao;

import com.bean.Order;
import com.bean.OrderItem;
import com.mysql.jdbc.Connection;

/**
 * 订单接口
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/14 21:14
 **/
public interface OrderDao {
    void saveOrder(Connection c, Order order);
    void saveOrderItem(Connection c, OrderItem item);

}
