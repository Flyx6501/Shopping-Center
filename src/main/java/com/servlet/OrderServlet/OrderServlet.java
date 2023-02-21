package com.servlet.OrderServlet;

import com.bean.Commodity;
import com.dao.CommodityDao;
import com.dao.OrdersDao;
import com.service.CommodityDaoImpl;
import com.service.OrdersDaoImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**将商品添加进订单
 * @author Qgs123
 * @version 1.0
 * @date 2023/2/21 10:56
 **/
public class OrderServlet extends HttpServlet {
     OrdersDao ordersDao=new OrdersDaoImpl();
     CommodityDao commodityDao=new CommodityDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String userName=String.valueOf(req.getParameter("userName"));
        List<Map> order= ordersDao.getOrderByUserName(userName);
        Integer commodityId = Integer.valueOf(req.getParameter("commodityId"));
        Integer commodityNum = Integer.valueOf(req.getParameter("commodityNum"));
        Integer userId=ordersDao.getUserIdByName(userName);
        ordersDao.addCommodity(userId,commodityId,commodityNum);
        List<Commodity> list=commodityDao.getUserCommodityList(userId);
        JSONObject json=new JSONObject();
        json.put("order",list);
        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
        resp.sendRedirect(String.valueOf(json));
    }
}