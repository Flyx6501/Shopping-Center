package com.servlet.manager;

import com.service.ManagerDaoImpl;
import com.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * aa
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/10 9:51
 **/
public class ManagerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        try {
            managerLogin(req,resp);
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
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private void managerLogin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException, ServletException {
       System.out.println(122);
        Connection c = JDBCUtil.getConnection();
        String adminName = req.getParameter("adminName");
        String password = req.getParameter("password");
        ManagerDaoImpl asp=new ManagerDaoImpl();
        boolean flag=asp.searchName((com.mysql.jdbc.Connection) c,adminName,password);
        System.out.println(flag);
        if (flag){
            req.setAttribute("message","管理员登陆成功");
            req.getRequestDispatcher("/success").forward(req,resp);
        }else {
            req.setAttribute("message","管理员登陆失败");
            req.getRequestDispatcher("/index.jsp");
        }



    }
}
