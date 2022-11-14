<%--
  @description: TODO
  @author: 86188
  @date: 2022/11/14 10:05
  @version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/frame/layui-2.6.8.js"></script>
    <script type="text/javascript" src="${APP_PATH}/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/sort.js"></script>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/frame/layui-2.6.8.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/frame/bootstrap-3.4.1-dist.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/sort.css" />
    <title>分类</title>
</head>
<body>
<!-- 头部导航 -->
<div class="nav-bar">
    <div class="layui-row">
        <!-- 返回首页 -->
        <div class="layui-col-md8">
            <a href="${APP_PATH}/userindex">返回首页</a>
        </div>
        <div class="layui-col-md2">
            <a href="${APP_PATH}/self">个人中心</a>
        </div>
        <div class="layui-col-md2">
            <i class="layui-icon layui-icon-cart-simple" style="color: #ddd;"></i>
            <a href="${APP_PATH}/car">购物车</a>
        </div>
    </div>
</div>
<!-- 留白布局 -->
<div class="layui-container">
    <!-- 分类名+搜索 -->
    <div class="layui-row">
        <!-- 分类名 -->
        <div class="layui-col-md2">
            <h3 class="sort-name">
                <b>
                    服装
                </b>
            </h3>
        </div>
        <!-- 搜索框 -->
        <div class="layui-col-md10">
            <div class="layui-col-md10">
                <div class="layui-col-md10">
                    <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                           class="layui-input">
                </div>
                <div class="layui-col-md2">
                    <button type="button" class="layui-btn layui-btn-danger layui-btn-radius">
                        搜索
                        <i class="layui-icon layui-icon-search" style="color: #fff;"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- 商品缩略 -->
    <div class="products">

    </div>
</div>
</body>
</html>