<%--
  @description: 商品详情界面
  @author: LL
  @date: 2022/11/14 10:42
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
    <script type="text/javascript" src="${APP_PATH}/static/js/details.js"></script>
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
        <div class="layui-col-md6">
            <div>商品详情</div>
        </div>
        <div class="layui-col-md2">
            <a href="${APP_PATH}/self">个人中心</a>
        </div>
        <div class="layui-col-md2">
            <i class="layui-icon layui-icon-cart-simple" style="color: #ddd;"></i>
            <a href="${APP_PATH}/car">购物车</a>
        </div>
        <div class="layui-col-md1">
            <!--获取用户名-->
            <div id="userName">
                <%=session.getAttribute("userName")%>
            </div>
        </div>
        <div class="layui-col-md1">
            <a href="${APP_PATH}/index">退出</a>
        </div>
    </div>
</div>
<!-- 留白布局 -->
<div class="layui-container">
    <div class="whole">
        <div class="preview" id="preview">
            <div class="d-images">
                <img id="img"
                     src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg14.360buyimg.com%2Fn1%2Fjfs%2Ft1%2F92724%2F24%2F20142%2F84153%2F61eaef16E03cabaca%2F14f6434ae59b63be.jpg&refer=http%3A%2F%2Fimg14.360buyimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670832219&t=d23c3ad36e3412ea0de3db91143eb962">
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
            <div class="add-cart" onclick="add()">
                <a href="#">加入购物车</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>