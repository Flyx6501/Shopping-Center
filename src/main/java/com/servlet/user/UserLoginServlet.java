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
 * 实现Servlet方法
 *
 * @author l666888999
 * @date 2022/11/08 21:26
 **/
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
        try {
            userLogin(request, response);
        } catch (SQLException  |ClassNotFoundException e) {
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

    /**
     * 用户登陆
     *
     * @param req  请求
     * @param resp 相应
     * @author l666888999
     * @date 2022/11/09 17:10
     **/
    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException, ServletException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserDaoImpl userDao = new UserDaoImpl();
        Connection c = null;
        c = (Connection) JDBCUtil.getConnection();
        boolean flag = userDao.getUserByUsernameAndPassword(c, userName, password);
        if (flag) {
            req.setAttribute("message", "登陆成功");
            req.getRequestDispatcher("/success").forward(req, resp);
        }else{
            req.setAttribute("message","登陆失败");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
