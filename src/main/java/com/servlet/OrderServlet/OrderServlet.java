package com.servlet.OrderServlet;

import com.bean.Commodity;
import com.bean.Order;
import com.bean.OrderItem;
import com.bean.User;
import com.mysql.jdbc.Connection;
import com.service.OlderService;
import com.service.OrderDaoImpl;
import com.utils.JDBCUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 订单类Servlet
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/16 14:57
 **/
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0, methodName.length() - 3);

        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        try {
            method.invoke(this, req, resp);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void orderServlet(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
        //int userId = Integer.parseInt(req.getParameter("userId"));
        // int buynum = Integer.parseInt(req.getParameter("buynum"));
        // int commodityId = Integer.parseInt(req.getParameter("commodityId"));
        //Connection c = (Connection) JDBCUtil.getConnection();
        Object userName = req.getSession().getAttribute("userName");
        //先把请求封装到Order中,填写相关信息。
        Order order = new Order();
        User user = new User();
        //为订单项赋值
        // order.setUser((User) userName);
        //随机生成一个id
        order.setId(UUID.randomUUID().toString());
        //获取用户名
        //order.setUser(user);
        //封装OrderItem中的商品
        ArrayList<OrderItem> items = new ArrayList<>();
        //先获得一个购物车，通过Map的方式
        //ToDo先从购物车里面将商品取出来
        Map<Commodity, Integer> cart = (Map<Commodity, Integer>) req.getSession().getAttribute("car");
        for (Map.Entry<Commodity, Integer> entry : cart.entrySet()) {
            OrderItem item = new OrderItem();
            item.setBuynum(entry.getValue());
            item.setCommodity(entry.getKey());
            //设置订单，用来判断商品属于哪张订单
            item.setOrder(order);
            items.add(item);
        }
        for (OrderItem item : items) {
            System.out.println("输出商品名称：" + item.getCommodity().getCommodityName() + "输出商品数量：" + item.getBuynum());
        }
        order.setList(items);
        //进行订单的插入
        // OrderDaoImpl dao=new OrderDaoImpl();
        // dao.addOrder(c,order);
        OlderService dao = new OlderService();
        dao.createOrder(order);
    }
}
