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
import com.service.CarDaoImpl;
import com.service.CommodityService;
import com.service.CommodityServiceImpl;
import org.json.JSONArray;

/**将商品添加进购物车
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/27 20:16
 **/
public class CarServlet extends HttpServlet {
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
        PrintWriter wirte = null;
        int result =-1;
        Map resultMap = new HashMap<>();
        String userId=String.valueOf(req.getParameter("userId"));
        List<Map> car= carDao.getCarByUserId(userId);
        Integer commodityId = Integer.valueOf(req.getParameter("commodityId"));
        Integer commodityNum = Integer.valueOf(req.getParameter("commodityNum"));
        Double priceTotal = Double.valueOf(0);
        for(Map commodity : car){
            result = carDao.addCommodity(userId,commodityId,commodityNum);
            Map commodityAdd = carDao.getCommodityById(String.valueOf(commodityId));

        }
        /**重定向网页
         */
        if(result<0){
            resultMap.put("result","error");
        }else{
            resultMap.put("result","success");
        }
        JSONArray array = new JSONArray();
        array.put(resultMap);
        wirte = resp.getWriter();
        wirte.print(array);
        resp.sendRedirect("index.do");
    }
}