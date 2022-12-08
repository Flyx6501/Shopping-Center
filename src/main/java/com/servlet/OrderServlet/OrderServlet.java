//package com.servlet.OrderServlet;
//
//import com.bean.Commodity;
//import com.bean.Order;
//import com.bean.OrderItem;
//import com.bean.User;
////import org.apache.commons.beanutils.BeanUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
////import javax.swing.*;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * 订单类Servlet
// *
// * @author l666888999
// * @version 1.0
// * @date 2022/11/16 14:57
// **/
//public class OrderServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String servletPath = req.getServletPath();
//        String methodName = servletPath.substring(1);
//        methodName = methodName.substring(0, methodName.length() - 3);
//
//        Method method = null;
//        try {
//            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            method.invoke(this, req, resp);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    private void orderServlet(HttpServletRequest req, HttpServletResponse resp)  {
//        //先把请求封装到Order中,填写相关信息。
//        Order order=new Order();
//        User user=new User();
//        Map<String, String[]> map = req.getParameterMap();
//        try {
//            BeanUtils.populate(order,map);
//        } catch (IllegalAccessException  | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//        //先获得一个购物车，通过Map的方式
//        //ToDo
//        Map<Commodity,Integer> car=(Map<Commodity, Integer>)req.getSession().getAttribute("car");
//
//
//        //随机生成一个id
//        order.setId(UUID.randomUUID().toString());
//        order.setOrdertime(new Date());
//       //获取用户名
//        //order.setUser(user);
//
//        //封装OrderItem中的商品
//        ArrayList<OrderItem> items = new ArrayList<>();
//        //将购物车中的商品取出来
//       // for (Map.Entry<Commodity,Integer> entry:map.entrySet()){
//
//        }
//
//    }
