package com.servlet;

import com.dao.UserDao;
import com.service.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        com.mysql.jdbc.Connection c=null;
        UserDao userdata=new UserDaoImpl();
        userdata.check(c,1,"123");


        if (userdata==null){

            System.out.println("用户名是不存在的");
        }else{
            System.out.println("欢迎您");
        }

       //获取请求的user、name
        request.setAttribute("user","userid");
        request.setAttribute("passwords","password");
        request.getRequestDispatcher(request.getContextPath()+"/index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
