package com.servlet.OrderServlet;

import com.mysql.jdbc.Connection;
import com.service.OrdersDaoImpl;
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

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/12/6 21:37
 **/
public class deleteOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        try {
            deleteOrders(req,resp);
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
    public void deleteOrders(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException{
        String commodityName = req.getParameter("commodityName");
        Connection c= (Connection) JDBCUtil.getConnection();
        OrdersDaoImpl dao=new OrdersDaoImpl();
        boolean flag = dao.deleteOrders(c, commodityName);
        if (flag){
            JSONObject json=new JSONObject();
            json.put("msg", true);
            PrintWriter out=resp.getWriter();
            out.println(json);
            out.close();
        }
    }
}