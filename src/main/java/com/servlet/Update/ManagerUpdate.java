package com.servlet.Update;

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
 * 后台修改用户信息
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/22 16:02
 **/
public class ManagerUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        try {
            updateManager(req,resp);
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
    private void updateManager(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
        Connection c= (Connection) JDBCUtil.getConnection();
        String userName = req.getParameter("userName");
        String email=req.getParameter("address");
        String address = req.getParameter("email");
        String nickName = req.getParameter("nickName");
        int Id= Integer.parseInt(req.getParameter("Id"));
        ManagerDaoImpl dao=new ManagerDaoImpl();
        boolean flag = dao.updateManagerById(c, userName, email, address, nickName, Id);
        if (flag){
            JSONObject json=new JSONObject();
            json.put("message","success");
            PrintWriter out=resp.getWriter();
            out.println(json);
            out.close();
        }else{
            JSONObject json=new JSONObject();
            json.put("message","failed");
            PrintWriter out=resp.getWriter();
            out.println(json);
            out.close();
        }
    }
}