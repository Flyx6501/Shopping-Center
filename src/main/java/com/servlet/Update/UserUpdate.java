package com.servlet.Update;

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
 * a
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/11 15:49
 **/
public class UserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        try {
            userUpdate(req, resp);
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

    private void userUpdate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
        Connection c = (Connection) JDBCUtil.getConnection();


        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String nickName = req.getParameter("nickName");
        String userId = req.getParameter("useId");
        UserDaoImpl as = new UserDaoImpl();
        boolean flag=as.updateUserByUserId(c, userName, password, email, nickName, Integer.parseInt(userId));
        if (flag){
            req.setAttribute("message", "修改成功");
        }


        //ToDo 转换
        //req.getRequestDispatcher().forward(req,resp);


    }
}