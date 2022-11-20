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

/**修改商品功能
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/19 22:13
 **/
public class UpdateCommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        try {
            updateCommodityServlet(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
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
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private void updateCommodityServlet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        Connection c = (Connection) JDBCUtil.getConnection();
        String commodityName = request.getParameter("commodityName");
        Double commodityPrice = Double.valueOf(request.getParameter("commodityPrice"));
        Integer commodityStock = Integer.valueOf(request.getParameter("commodityStock"));
        String commodityInformation=request.getParameter("commodityInformation");
        Integer commodityId = Integer.valueOf(request.getParameter("commodityId"));
        CommodityDaoImpl as = new CommodityDaoImpl();
        boolean flag=as.updateCommodity(c,commodityName,commodityPrice,commodityStock,commodityInformation,commodityId);
        JSONObject json=new JSONObject();
        if (flag){
            json.put("message","success");
            PrintWriter out=response.getWriter();
            out.println(json);
            out.close();
        }else{
            json.put("message","failed");
            PrintWriter out=response.getWriter();
            out.println(json);
            out.close();
        }
    }
}