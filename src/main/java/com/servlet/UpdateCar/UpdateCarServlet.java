package com.servlet.UpdateCar;

import com.bean.Car;
import com.bean.CarOperate;
import com.dao.CarDao;
import com.service.CarDaoImpl;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**拿到购物车,先将传过来的id接收到
         */
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter wirte = null;
        int result =-1;
        Map resultMap = new HashMap<>();
        String userId=String.valueOf(req.getParameter("userId"));
        List<Map> car= carDao.getCarByUserId(userId);

        Integer commodityId = Integer.valueOf(req.getParameter("commodityId"));
        Integer commodityNum = Integer.valueOf(req.getParameter("commodityNum"));

        Double priceTotal = Double.valueOf(0);
        for(Map commodity : car){
            priceTotal = priceTotal + Integer.parseInt(commodity.get("car_commodity_num").toString()) * Double.parseDouble(commodity.get("commodity_price").toString());
            /**购物车中有该商品
            */
            if(commodity.get("car_commodity_id").equals(commodityId)){
                Integer carId =  Integer.parseInt(commodity.get("car_id").toString());
                int commodityNumNew = commodityNum;
                result = carDao.updateCommodity(carId,userId,commodityId,commodityNumNew);
                priceTotal += commodityNum * Double.parseDouble(commodity.get("commodity_price").toString());
            }else{
                /**购物车中没有该商品
                */
                result = carDao.addCommodity(userId,commodityId,commodityNum);
                Map commodityAdd = carDao.getCommodityById(String.valueOf(commodityId));
                priceTotal += commodityNum * Double.parseDouble(commodityAdd.get("commodity_price").toString());
            }

        }
        resultMap.put("priceTotal",priceTotal);
        /**重定向网页
         */
        if(result<0){
            resultMap.put("result","error");
        }else{
            resultMap.put("result","success");
        }
        /**声明JSONArray对象并输入JSON字符串
        */
         JSONObject json=new JSONObject();
        json.put("result",resultMap);
        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
    }
}