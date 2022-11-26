package com.servlet.GetUser;

import com.bean.Page;
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
 * 返回所有商品信息
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/16 8:56
 **/

public class getUserByUserName extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        try {
            getUserByUserName(req, resp);
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
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void getUserByUserName(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
        String userName = req.getParameter("userName");
        ManagerDaoImpl dao = new ManagerDaoImpl();
        Connection c = JDBCUtil.getConnection();
        int totalDate = dao.getTotalNum((com.mysql.jdbc.Connection) c,userName);
        int pageSize=5;
        int currentPage= Integer.parseInt(req.getParameter("page"));
        int totalPage=(int)Math.ceil((double)totalDate/pageSize);
        if (currentPage>totalPage){
            currentPage=totalPage;
        }
        List<User> list = dao.getUserByUserName((com.mysql.jdbc.Connection) c, userName,currentPage,pageSize);
        Page pg = new Page(currentPage, pageSize, totalDate);
        pg.setPageDate(list);
        JSONObject json=new JSONObject();
        json.put("msg",pg);

        PrintWriter out=resp.getWriter();
        out.println(json);
        out.close();
       // req.setAttribute("pg",pg);
        //ToDo 路径补充
        try {
            req.getRequestDispatcher("").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}