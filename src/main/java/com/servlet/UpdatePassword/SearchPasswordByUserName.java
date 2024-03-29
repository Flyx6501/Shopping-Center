package com.servlet.UpdatePassword;

import com.mysql.jdbc.Connection;
import com.service.UserDaoImpl;
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
 * @date 2022/11/17 8:31
 **/
public class SearchPasswordByUserName extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req,resp);
        try {
            searchPasswordByUserName(req,resp);
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
    private void searchPasswordByUserName(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
       // String password=req.getParameter("password");
        Connection c = (Connection) JDBCUtil.getConnection();
        //String firstPassword=req.getParameter("firstPassword");
        String userName = req.getParameter("userName");
        String passwords=req.getParameter("password");
        UserDaoImpl dao=new UserDaoImpl();
        boolean flag = dao.searchUserByPassword(c,userName,passwords);
        System.out.println(userName);
        System.out.println(passwords);
        if (flag){
            JSONObject json = new JSONObject();
            json.put("msg","success");
            PrintWriter out=resp.getWriter();
            out.println(json);
            out.close();
          //  req.setAttribute("msg","修改密码成功");
        }else{
            JSONObject json=new JSONObject();
            json.put("msg","failed");

            PrintWriter out=resp.getWriter();
            out.println(json);
            out.close();

        }
    }
}