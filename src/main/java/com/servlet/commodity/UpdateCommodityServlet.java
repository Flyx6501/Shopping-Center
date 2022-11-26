package com.servlet.commodity;

import com.mysql.jdbc.Connection;
import com.service.CommodityDaoImpl;
import com.utils.JDBCUtil;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**管理员更新商品的信息 根据id修改
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/26 11:05
 **/
public class UpdateCommodityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0, methodName.length() - 3);

        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        try {
            method.invoke(this, req, resp);
        } catch (IllegalAccessException |InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        try {
            updateCommodity(request, response);
        } catch (SQLException |ClassNotFoundException e)  {
            throw new RuntimeException(e);
        }
    }
    /** 管理员更新商品信息
     * @param request 请求
     * @param response 响应
     * @author Qgs123
     * @date 2022/11/26 11:09
     **/
    private void updateCommodity(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException{
        String commodityName = request.getParameter("commodityName");
        Double commodityPrice = Double.valueOf(request.getParameter("commodityPrice"));
        Integer commodityStock = Integer.valueOf(request.getParameter("commodityStock"));
        String commodityInformation=request.getParameter("commodityInformation");
        Integer commpdityId=Integer.valueOf(request.getParameter("commodityId"));
        Connection c = (Connection) JDBCUtil.getConnection();
        CommodityDaoImpl dao = new CommodityDaoImpl();
        boolean flag = dao.updateCommodity(c,commodityName,commodityPrice,commodityStock,commodityInformation,commpdityId);
        if (flag){
            JSONObject json=new JSONObject();
            json.put("msg",200);
            PrintWriter out=response.getWriter();
            out.println(json);
            out.close();
        }
    }

}