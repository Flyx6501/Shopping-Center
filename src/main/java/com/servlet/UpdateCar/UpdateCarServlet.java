package com.servlet.UpdateCar;

import com.bean.Car;
import com.bean.CarOperate;
import com.bean.Commodity;
import com.dao.CarDao;
import com.dao.CommodityDao;
import com.service.CarDaoImpl;
import com.service.CommodityDaoImpl;
import com.utils.CommodityNotFindException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** 修改购物车商品数量操作
 * @author Qgs123
 * @date 2022/11/16 22:08
 **/
public class UpdateCarServlet extends HttpServlet{
    CarDao carDao =new CarDaoImpl();
    CommodityDao commodityDao = new CommodityDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**拿到购物车
         *先将传过来的id接收到
         */
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String userName=String.valueOf(req.getParameter("userName"));
        List<Map> car= carDao.getCarByUserName(userName);
        Integer commodityId = Integer.valueOf(req.getParameter("commodityId"));
        Integer commodityNum = Integer.valueOf(req.getParameter("commodityNum"));
        Integer userId = 0;
        int result =0;
        for(Map commodity : car){
            /**购物车中有该商品
            */
            userId =  Integer.parseInt(commodity.get("user_id").toString());
            if(commodity.get("car_commodity_id").equals(commodityId)){
                Integer carId =  Integer.parseInt(commodity.get("car_id").toString());
                int commodityNumNew = commodityNum;
                result = carDao.updateCommodity(carId,userId,commodityId,commodityNumNew);
            }
        }
        if (result <=0){
            /**购物车中没有该商品
            */
            carDao.addCommodity(userId,commodityId,commodityNum);
        }
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