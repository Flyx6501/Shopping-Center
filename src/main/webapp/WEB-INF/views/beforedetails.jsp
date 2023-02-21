<%--
  @description: 商品详情界面（登录前）
  @author: LL
  @date: 2023/01/14 10:42
  @version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>详情</title>
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
    <!-- layui -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
    <!-- Jquery -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <!-- 引入js验证文件-->
    <script type="text/javascript" src="${APP_PATH}/static/js/beforedetails.js"></script>
    <!-- layui -->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/layui-2.6.8.css" />
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css" />
    <!-- 引入css样式-->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/details.css" />
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
<!-- 留白布局 -->
<div class="layui-container">
    <div class="whole">
        <div class="preview" id="preview">
            <div class="d-images" id="photo">
                <img id="img" src=>
            </div>
        </div>
        <div class="itemInfo-wrap">
            <div class="d-goodsname">
                <h3 id="goodsName"></h3>
            </div>
            <div class="news">
                <div class="d-props" id="props">

                </div>
            </div>
            <div class="d-price">
                <span>￥</span>
                <div class="d-pricenum" id="price"></div>
            </div>
            <input class="input" type="hidden" name="orderId" id="num" value="1">
        </div>
    </div>
</div>
</body>
</html>