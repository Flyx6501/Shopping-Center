package com.servlet.UpdateCar;

import com.bean.Car;
import com.bean.CarOperate;

import java.io.IOException;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**拿到购物车
         */
        CarOperate car = new CarOperate((Map<String, Integer>) req.getSession().getAttribute("car"));
        /**接收到传过来的值
         */
        int id=Integer.parseInt(req.getParameter("id"));
        int type=Integer.parseInt(req.getParameter("type"));
        for (String cId : car.getCar().keySet()) {
            if(Objects.equals(cId, id)) {
                int count=car.getCar().get(cId)+type;
                /**设置该商品的数量
                 */
                if(count<1){
                    break;}
                car.add(cId,count);
            }
        }
        /**遍历购物车将总价加上
         */
        Double sum= Double.valueOf(0);
        sum = car.getCarPriceCount();
        req.getSession().setAttribute("sum",sum);
        resp.sendRedirect("car.jsp");
    }
}