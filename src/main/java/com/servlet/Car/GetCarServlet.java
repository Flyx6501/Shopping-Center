package com.servlet.Car;

import com.bean.Commodity;
import com.dao.CarDao;
import com.dao.CommodityDao;
import com.service.CarDaoImpl;
import com.service.CommodityDaoImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**  获取购物车里商品列表
 * @author Qgs123
 * @date 2022/12/06 15:31
 **/
public class GetCarServlet extends HttpServlet {
    CommodityDao commodityDao = new CommodityDaoImpl();
    CarDao carDao= new CarDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**先将传过来的id接收到
         */
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String userName=String.valueOf(req.getParameter("userName"));

        List<Map> car= carDao.getCarByUserName(userName);
        Integer userId = 0;
        for(Map commodity : car){
            userId = (Integer) commodity.get("user_id");
        }
        List<Commodity> list =  commodityDao.getUserCommodityList(userId);
        JSONObject json=new JSONObject();
        json.put("commodity",list);
        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
        resp.sendRedirect(String.valueOf(json));
    }
}