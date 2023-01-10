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
import java.io.OutputStream;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

/**商品信息图片显示
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/21 21:50
 **/
public class CommodityGetOnePhotoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String temp = request.getParameter("id");
        Integer id = parseInt(temp);
        CommodityDao commodityDao = new CommodityDaoImpl();
        Commodity list1=commodityDao.getOnePhoto(id);
        JSONObject json=new JSONObject();
        String img=list1.getCommodityPhoto();
        json.put("commodity",img);
        PrintWriter out=response.getWriter();
        out.println(json);
        out.close();
    }
}