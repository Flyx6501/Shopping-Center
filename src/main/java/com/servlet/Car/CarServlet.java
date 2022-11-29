package com.servlet.Car;

import com.bean.Car;
import com.bean.CarOperate;
import com.bean.Commodity;
import com.service.CommodityService;
import com.service.CommodityServiceImpl;
import com.servlet.commodity.CommodityServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 23130
 * @version 1.0
 * @date 2022/11/27 20:16
 **/
public class CarServlet extends HttpServlet {
    CommodityService commodityService=new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarOperate car = new CarOperate((Map<String, Integer>) req.getSession().getAttribute("car"));
        /**先将传过来的id接收到
         */
        String id=String.valueOf(req.getParameter("id"));
        car.add(id);
        /**遍历购物车将总价加上
         */
        Double sum= Double.valueOf(0);
        sum = car.getCarPriceCount();
        req.getSession().setAttribute("sum",sum);
        /**重定向网页
         */
        resp.sendRedirect("index.do");
    }
}