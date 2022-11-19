package com.servlet.DeleteCar;

import com.bean.Car;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
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
         List<Car> car=(List<Car>)req.getSession().getAttribute("car");
        /**先接收到id
        */
        int id=Integer.parseInt(req.getParameter("id"));
        Car i=null;
        /**遍历购物车
        */
        for (Car c : car) {
            if(Objects.equals(c.getCommodity().getCommodityId(), id)) i = c;
        }
        /**将商品删除
        */
        car.remove(i);
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