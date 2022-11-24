package com.servlet.Delete;

import com.mysql.jdbc.Connection;
import com.service.ManagerDaoImpl;
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
 * 删除用户
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/21 22:16
 **/
public class DeleteUserById extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        try {
            deleteUserByIds(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
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
        } catch (IllegalAccessException |InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteUserByIds(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));

        Connection c= (Connection) JDBCUtil.getConnection();
        ManagerDaoImpl dao = new ManagerDaoImpl();
        boolean flag = dao.deleteUserById(c,id);
        if (flag){
            JSONObject json=new JSONObject();
            json.put("msg",200);

            PrintWriter out=resp.getWriter();
            out.println(json);
            out.close();
        }
    }
}