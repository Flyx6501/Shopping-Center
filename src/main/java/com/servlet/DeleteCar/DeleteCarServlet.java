package com.servlet.DeleteCar;

import com.bean.Car;
import com.bean.CarOperate;
import com.bean.Commodity;
import com.utils.CommodityNotFindException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**删除购物车商品操作
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/15 19:42
 **/
public class DeleteCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**拿到购物车
         */
        CarOperate car = new CarOperate((Map<String, Integer>) req.getSession().getAttribute("car"));
        /**先接收到id
         */
        int id=Integer.parseInt(req.getParameter("id"));
        Commodity i=new Commodity();
        /**遍历购物车
         */
        for (String commodityId : car.getCar().keySet()) {
            if(Objects.equals(commodityId, id)) {
                try {
                    car.remove(commodityId);
                } catch (CommodityNotFindException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        /**遍历购物车将总价加上
         */
        Double priceCount = car.getCarPriceCount();
        req.getSession().setAttribute("sum",priceCount);
        resp.sendRedirect("car.jsp");
    }
}