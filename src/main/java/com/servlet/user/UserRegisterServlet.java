package com.servlet.user;

import com.mysql.jdbc.Connection;
import com.service.UserDaoImpl;
import com.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * 用户注册Servlet
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/9 19:35
 **/
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        try {
            registerUser(request, response);
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

    /**
     * 用户注册
     *
     * @param req  请求
     * @param resp 相应
     * @author l666888999
     * @date 2022/11/09 17:10
     **/
    private void registerUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException, ServletException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String nickName = req.getParameter("nickName");
        String email = req.getParameter("email");

        Connection c = (Connection) JDBCUtil.getConnection();
        UserDaoImpl dao = new UserDaoImpl();
        boolean as1 = dao.registerName(c, password, email, nickName, userName);

        if (as1) {
            req.setAttribute("useName",userName);
            req.setAttribute("nikName",nickName);
            req.setAttribute("password",password);
            req.setAttribute("email",email);
            // req.setAttribute("confirm",confirm);
            req.setAttribute("message", "注册成功");

            req.getRequestDispatcher(req.getContextPath() + "/register.jsp").forward(req, resp);
        }
    }

}