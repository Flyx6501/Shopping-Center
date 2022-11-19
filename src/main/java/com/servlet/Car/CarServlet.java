package com.servlet.Car;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Car;
import com.bean.Commodity;
import com.service.CommodityService;
import com.service.CommodityServiceImpl;
/** 将商品添加进购物车
 * @author Qgs123
 * @date 2022/11/15 16:06
 **/
public class CarServlet extends HttpServlet{
    CommodityService commodityService=new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> car=(List<Car>)req.getSession().getAttribute("car");
        /**先将传过来的id接收到
        */
        int id=Integer.parseInt(req.getParameter("id"));
        boolean f=true;
        /**判断该商品是否已经存在购物车中，如何存在只在数量上相加
       */
        for (Car c : car) {
            if(c.getCommodity().getCommodityId()==id) {
                /**设置数量加1
                */
                c.setCarCommodityCount(c.getCarCommodityCount()+1);
                /**设置商品总价
                */
                c.setCarCommodityTotal(c.getCarCommodityCount()*c.getCommodity().getCommodityPrice());
                f=false;
                break;
            }
        }
        if(f) {
            /**当商品不存在时
            *根据id进行查询商品
            */
            Commodity commodity= commodityService.getOne(id);
            Car c=new Car();
            c.setCommodity(commodity);
            /**商品的数量设置
            */
            c.setCarCommodityCount(1);
            /**商品的总价设置
            */
            c.setCarCommodityTotal(c.getCommodity().getCommodityPrice());
            car.add(c);
        }
        /**遍历购物车将总价加上
        */
         int sum=0;
        for (Car car2 : car) {
            sum+=car2.getCarCommodityTotal();
        }
        req.getSession().setAttribute("sum",sum);
        /**重定向网页
        */
        resp.sendRedirect("index.do");
    }
}