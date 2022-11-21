<%--
  @description: TODO
  @author: 小花妹妹
  @date: 2022/11/14 2:03
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
    <title></title>
    <link rel="stylesheet" href="${APP_PATH}/static/css/customer.css">
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css">
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>


</head>
<body class="layui-layout-body">
<input type="hidden" value="${APP_PATH}" id="baseUrl">
<!-- 内容主体区域 -->
<div class="child-page">


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">用户名称</label>
            <div class="layui-input-inline">
                <!--注意此处input标签里的id-->
                <input id="customer-search-btn" class="layui-input" name="keyword" id="keyword" autocomplete="off">
            </div>
        </div>
        <div class="layui-inline">
            <!--注意此处button标签里的type属性-->
            <button class="layui-btn layui-btn-primary" lay-event="search"><i class="layui-icon"></i> 搜 索</button>
        </div>
    </div>


    <div class="layui-btn-group demoTable">
        <button class="layui-btn" id="add">新增</button>
    </div>
    <!-- 顾客信息数据表格 -->
    <table id="demo" lay-filter="test" lay-data="{id: 'test'}"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>


</div>
<script type="text/javascript" src="${APP_PATH}/static/js/customer.js"></script>
</body>
</html>
