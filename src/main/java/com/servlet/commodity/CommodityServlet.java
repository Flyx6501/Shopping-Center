package com.servlet.commodity;

import com.bean.Commodity;
import com.dao.CommodityDao;
import com.mysql.jdbc.Connection;
import com.service.CommodityDaoImpl;
import com.service.CommodityService;
import com.service.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/** TODO
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
        request.setAttribute("commodity",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

