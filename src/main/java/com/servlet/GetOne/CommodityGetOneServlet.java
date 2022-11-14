package com.servlet.GetOne;

import com.bean.Commodity;
import com.dao.CommodityDao;
import com.service.CommodityDaoImpl;
import com.service.CommodityService;
import com.service.CommodityServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;


/**
 * @author  Qgs123
 * @version 1.0
 * @date 2022/11/13 22:30
 **/
@WebServlet("/inde.do")
public class CommodityGetOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String temp = request.getParameter("id");
        Integer id = parseInt(temp);
        CommodityService commodityService=new CommodityServiceImpl();
        Commodity list1=commodityService.getOne(id);
        JSONObject json=new JSONObject();
        json.put("commodity",list1);
        PrintWriter out=response.getWriter();
        out.println(json);
        out.close();
    }

}