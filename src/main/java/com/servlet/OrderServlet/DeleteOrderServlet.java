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

/**用户订单删除
 * @author Qgs123
 * @version 1.0
 * @date 2023/2/21 11:59
 **/
public class DeleteOrderServlet extends HttpServlet {
    CommodityDao commodityDao = new CommodityDaoImpl();
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
        List<Map> car= ordersDao.getOrderByUserName(userName);
        Integer commodityId = Integer.valueOf(req.getParameter("commodityId"));
        Integer userId=0;
        for(Map commodity : car){
            if(commodity.get("order_commodity_id") == commodityId){
                    userId =  Integer.parseInt(commodity.get("user_id").toString());
                    ordersDao.deleteCommodity(userId,commodityId);
            }
        }
        List<Commodity> list =  ordersDao.getOrderCommodityList(userId);
        JSONObject json=new JSONObject();
        json.put("commodity",list);
        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
        resp.sendRedirect(String.valueOf(json));
    }
}