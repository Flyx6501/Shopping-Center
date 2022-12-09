package com.servlet.Car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Car;
import com.bean.CarOperate;
import com.bean.Commodity;
import com.dao.CarDao;
import com.dao.CommodityDao;
import com.service.CarDaoImpl;
import com.service.CommodityDaoImpl;
import com.service.CommodityService;
import com.service.CommodityServiceImpl;
import org.json.JSONObject;

/**将商品添加进购物车
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/27 20:16
 **/
public class CarServlet extends HttpServlet {
    CarDao carDao= new CarDaoImpl();
    CommodityDao commodityDao = new CommodityDaoImpl();
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

        Integer commodityId = Integer.valueOf(req.getParameter("commodityId"));
        Integer commodityNum = Integer.valueOf(req.getParameter("commodityNum"));
        Integer userId = carDao.getUserIdByName(userName);

        carDao.addCommodity(userId,commodityId,commodityNum);
        /**重定向网页
         */
        List<Commodity> list =  commodityDao.getUserCommodityList(userId);
        /**声明JSONArray对象并输入JSON字符串
        */
        JSONObject json=new JSONObject();
        json.put("commodity",list);
        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
        resp.sendRedirect(String.valueOf(json));
    }
}