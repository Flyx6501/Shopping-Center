package com.servlet.DeleteCar;

import com.bean.Car;
import com.bean.CarOperate;
import com.bean.Commodity;
import com.dao.CarDao;
import com.service.CarDaoImpl;
import com.utils.CommodityNotFindException;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**删除购物车商品操作
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/15 19:42
 **/
public class DeleteCarServlet extends HttpServlet {
    CarDao carDao =new CarDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**拿到购物车
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
            /**购物车中有该商品
            */
            if(commodity.get("car_commodity_id") == commodityId){

                int commodityNumNew = Integer.parseInt(commodity.get("car_commodity_num").toString()) - commodityNum;
                if(commodityNumNew>0){
                    Integer carId =  Integer.parseInt(commodity.get("car_id").toString());
                    result = carDao.updateCommodity(carId,userId,commodityId,commodityNumNew);
                }
                if(commodityNumNew==0){
                    result = carDao.deleteCommodity(userId,commodityId);
                }
            }

        }
        /**重定向网页
         */
        if(result<0){
            resultMap.put("result","error");
        }else{
            resultMap.put("result","success");
        }
        /**声明JSONArray对象并输入JSON字符串
       */
        JSONArray array = new JSONArray();
        array.put(resultMap);
        wirte = resp.getWriter();
        wirte.print(array);
        resp.sendRedirect("index.do");
    }
}