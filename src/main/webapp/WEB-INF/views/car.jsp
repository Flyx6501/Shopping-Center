<%--
  @description: 购物车
  @author: LL
  @date: 2022/11/14 10:15
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
    <title>购物车</title>
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
    <script type="text/javascript" src="${APP_PATH}/static/js/car.js"></script>
    <!-- layui -->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/layui-2.6.8.css" />
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css" />
    <!-- 引入css样式-->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/car.css" />
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<!-- 头部导航 -->
<div class="nav-bar">
    <div class="layui-row">
        <div class="layui-col-md6">
            <div>购物车</div>
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
<div class="layui-container">
    <div class="cart">
        <div class="cart-head">
            <div class="column g-select">
                <div class="select-all">
                    <input type="checkbox" class="all each" id="all" value="0">
                    全选
                </div>
            </div>
            <div class="column g-goodsname">商品名称</div>
            <div class="column g-props">商品信息</div>
            <div class="column g-price">单价</div>
            <div class="column g-quantity">数量</div>
            <div class="column g-sum">小计</div>
            <div class="column g-action">操作</div>
        </div>
        <form action="#" method="post" id="addOrder" name="car">
            <div id="car">

            </div>
    <div class="payment">
        <div class="cart-pay">
            <div class="pay-right">
                <div class="right-compute">
                    <div class="btn">
                        <!-- 结算页 -->
                        <input type="submit" id="submitBtn" class="submit-btn" value="结算" onclick="checkSome()">
                    </div>
                    <div class="price-sum">
                        <div class="price-show">总价是：</div>
                        <div class="show-money">
                            ￥
                            <span id="money">0</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
</div>
</body>
</html>