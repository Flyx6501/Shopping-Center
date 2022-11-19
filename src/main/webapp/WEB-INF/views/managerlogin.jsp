<%--
  @description: TODO
  @author: 小花妹妹
  @date: 2022/11/14 2:00
  @version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	<meta charset="utf-8">
	<title>后台管理员系统</title>
	<link rel="stylesheet" href="${APP_PATH}/static/css/managerlogin.css">
	<link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css">
    <script type="text/javascript" src="${APP_PATH}/static/js/managerlogin.js"></script>
	<script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
	<script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>

</head>
<body class="layui-layout-body">
<!-- 用layui布局头部的内容 -->
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">商城后台管理系统</div>
        <!-- 水平导航 layui-nav -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="${APP_PATH}/static/img/pic1.jpg" class="layui-nav-img">
                    <%=request.getAttribute("adminName")%>
                </a>

                <dl class="layui-nav-child">
                    <dd><a href="${APP_PATH}/admin">登录</a></dd>
                    <dd><a href="${APP_PATH}/admin">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域 -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="${APP_PATH}/commodity" target="iframe_commodity">商品管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${APP_PATH}/customer" target="iframe_customer">用户管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${APP_PATH}/order" target="iframe_order">订单管理</a>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="home-page">
            <div class="box" style="background: rgb(63, 165, 179);">
                <h1>欢迎来到商城后台管理系统</h1>
                <img src="${APP_PATH}/static/img/pic2.jpg">
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <div>底部</div>
    </div>
</div>
</html>
