package com.servlet.find;

import com.service.UserDaoImpl;
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
 * @date 2022/11/10 17:17
 **/
public class FindUserByUserName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        try {
            findUserName(req, resp);
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

    private void findUserName(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException, ServletException {
        String userName = req.getParameter("userName");
        Connection c = JDBCUtil.getConnection();
        UserDaoImpl as1 = new UserDaoImpl();
        boolean flag = as1.findUserByUserName((com.mysql.jdbc.Connection) c, userName);
        if (flag) {
            req.setAttribute("message", "该用户名已经存在");
            req.getRequestDispatcher("/register").forward(req, resp);
        }


    }
}