<%--
  @description: 搜索结果
  @author: LL
  @date: 2023/01/14 21:49
  @version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>搜索结果</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!--定义绝对路径-->
    <script type="text/javascript">
        let APP_PATH=${APP_PATH};
    </script>
    <!--定义用户名-->
    <script type="text/javascript">
        let userName = "<%=session.getAttribute("userName")%>";
    </script>
    <!-- Jquery -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <!-- layui -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
    <!-- 引入js验证文件-->
    <script type="text/javascript" src="${APP_PATH}/static/js/beforeresult.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css">
    <!-- layui -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css">
    <!-- 引入css样式-->
    <link rel="stylesheet" href="${APP_PATH}/static/css/sort.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<!-- 头部导航 -->
<div class="nav-bar">
    <div class="layui-row">
        <!-- 登录/注册 -->
        <div class="layui-col-md8">
            <a href="${APP_PATH}/login">登录</a>
            <span>/</span>
            <a href="${APP_PATH}/register">注册</a>
        </div>
        <div class="layui-col-md2">
        </div>
        <div class="layui-col-md2">
        </div>
    </div>
</div>
<div class="layui-container">
    <!--商品列表-->
    <div class="good-list" id="goodlist">

    </div>
</div>

</body>
</html>