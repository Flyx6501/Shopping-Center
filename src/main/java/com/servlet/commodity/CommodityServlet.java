package com.servlet.commodity;

import com.bean.Commodity;
import com.service.CommodityService;
import com.service.CommodityServiceImpl;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/** 首页商品数据显示
 * @author Qgs123
 * @date 2022/11/10 10:00
 **/
public class CommodityServlet extends HttpServlet {
    public CommodityServlet(){
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CommodityService commodityService=new CommodityServiceImpl();
        List<Commodity> list=commodityService.getCommodityList();
        JSONObject json=new JSONObject();
        json.put("commodity",list);
        PrintWriter out=response.getWriter();
        out.println(json);
        out.close();
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

