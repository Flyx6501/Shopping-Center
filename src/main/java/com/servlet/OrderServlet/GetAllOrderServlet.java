package com.servlet.OrderServlet;

import com.dao.OrdersDao;
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

/**后台管理员查看订单信息
 * @author Qgs123
 * @version 1.0
 * @date 2023/2/21 16:45
 **/
public class GetAllOrderServlet extends HttpServlet {
    OrdersDao ordersDao=new OrdersDaoImpl();
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
        List<Map> list =  ordersDao.getAllOrderList(userName);
        JSONObject json=new JSONObject();
        json.put("order",list);
        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
    }
}