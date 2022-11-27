package com.servlet.GetOne;

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

/** 商品模糊查询
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/27 19:40
 **/
public class CommodityGetFuzzyQueryServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        CommodityDao commodityService=new CommodityDaoImpl();
        List<Commodity> list=commodityService.getFuzzyQueryCommodity(name);
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