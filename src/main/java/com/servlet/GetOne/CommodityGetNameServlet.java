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


/**根据商品名获取商品详细信息
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/26 9:33
 **/
public class CommodityGetNameServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String temp = request.getParameter("commodityName");
        CommodityDao commodityService=new CommodityDaoImpl();
        List<Commodity> list=commodityService.getNameCommodity(temp);
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