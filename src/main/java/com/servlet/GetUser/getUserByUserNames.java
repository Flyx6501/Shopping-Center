package com.servlet.GetUser;

import com.bean.User;
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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 不分页
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/21 12:02
 **/
public class getUserByUserNames extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req,resp);
        try {
            getUserByUserNames(req,resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
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
    private void getUserByUserNames(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
        String userName = req.getParameter("userName");
        Connection c = JDBCUtil.getConnection();
        ManagerDaoImpl dao=new ManagerDaoImpl();
        List<User> list = dao.getUserByUserNames((com.mysql.jdbc.Connection) c, userName);
        JSONObject json=new JSONObject();
        json.put("msg",list);

        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
        //req.setAttribute("userList", list);

    }

}