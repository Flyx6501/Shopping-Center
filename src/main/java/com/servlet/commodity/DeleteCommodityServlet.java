package com.servlet.commodity;

import com.mysql.jdbc.Connection;
import com.service.CommodityDaoImpl;
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
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/20 14:47
 **/
public class DeleteCommodityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        try {
            deleteCommodity(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /** 商品删除
     * @param request 请求
     * @param response 响应
     * @author Qgs123
     * @date 2022/11/18 22:10
     **/
    private void deleteCommodity(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException, ServletException {
        Integer commodityId = Integer.valueOf(request.getParameter("commodityId"));

        Connection c = (Connection) JDBCUtil.getConnection();
        CommodityDaoImpl dao = new CommodityDaoImpl();

        boolean flag = dao.deleteCommodity(c,commodityId);
        System.out.println(flag);

        if (flag) {
            request.setAttribute("message", "删除成功");
            request.getRequestDispatcher("/success").forward(request,response);
        }else {
            request.setAttribute("message","删除失败");
            request.getRequestDispatcher("/commodityAdd").forward(request,response);
        }
    }
}