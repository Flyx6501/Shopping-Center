package com.servlet.commodity;

import com.bean.Commodity;
import com.dao.CommodityDao;
import com.service.CommodityDaoImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.Integer.parseInt;

/**查询某个商品详细信息
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/23 21:06
 **/
public class GetOneCommodityServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String temp = request.getParameter("id");
        Integer id = parseInt(temp);

        CommodityDao commodityService=new CommodityDaoImpl();
        List<Commodity> list=commodityService.getOneCommodity(id);
        JSONObject json=new JSONObject();
        json.put("commodity",list);
        PrintWriter out=response.getWriter();
        out.println(json);
        out.close();

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}