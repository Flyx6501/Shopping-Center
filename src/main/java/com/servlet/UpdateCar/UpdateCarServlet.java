package com.servlet.UpdateCar;

import com.bean.Car;
import java.io.IOException;
import java.util.List;
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
        List<Car> car=(List<Car>)req.getSession().getAttribute("car");
        /**接收到传过来的值
        */
        int id=Integer.parseInt(req.getParameter("id"));
        int type=Integer.parseInt(req.getParameter("type"));
        for (Car c : car) {
            if(Objects.equals(c.getCommodity().getCommodityId(), id)) {
                int count=c.getCarCommodityCount()+type;
                /**设置该商品的数量
               */
                if(count<1)break;
                c.setCarCommodityCount(count);
                c.setCarCommodityTotal(c.getCarCommodityCount()*c.getCommodity().getCommodityPrice());
            }
        }
        /**遍历购物车将总价加上
        */
        int sum=0;
        for (Car car2 : car) {
            sum+=car2.getCarCommodityTotal();
        }
        req.getSession().setAttribute("sum",sum);
        resp.sendRedirect("car.jsp");
    }
}