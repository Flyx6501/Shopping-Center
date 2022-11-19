<%--
  @description: 我的订单
  @author: LL
  @date: 2022/11/17 0:07
  @version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript">
        let userName = "<%=session.getAttribute("userName")%>";
    </script>
    <%--    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
        <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>
    <!-- Jquery -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css" />

    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css" />

    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>

    <!-- 引入js验证文件-->
    <script type="text/javascript" src="${APP_PATH}/static/js/userOrder.js"></script>
    <!-- 引入css样式-->
    <link rel="stylesheet" href="${APP_PATH}/static/css/userOrder.css" />
    <title>我的订单</title>
</head>
<body>
<div class="nav-bar">
    <div class="layui-row">
        <!-- 首页 -->
        <div class="layui-col-md6">
            <div>首页</div>
        </div>
        <div class="layui-col-md2">
            <a href="${APP_PATH}/self">个人中心</a>
        </div>
        <div class="layui-col-md2">
            <i class="layui-icon layui-icon-cart-simple" style="color: #ddd;"></i>
            <a href="${APP_PATH}/car">购物车</a>
        </div>
        <div class="layui-col-md1">
            <!-- 获取用户名 -->
            <div id="userName">
                <%=session.getAttribute("userName")%>
                <%--<%=request.getAttribute("userName")%>--%>
            </div>
        </div>
        <div class="layui-col-md1">
            <a href="${APP_PATH}/index">退出</a>
        </div>
    </div>
</div>
<!-- 留白布局 -->
<div class="layui-container">
    <div class="layui-col-md2">
        <!-- 分类 -->
        <ul class="left-nav">
            <li><a href="${APP_PATH}/self">个人信息</a></li>
            <li class="active"><a href="#">我的订单</a></li>
            <li><a href="${APP_PATH}/password">修改密码</a></li>
        </ul>
    </div>
    <div class="layui-col-md10">
        <div class="cart-head">
            <div class="column g-images">图片</div>
            <div class="column g-goodsname">商品名称</div>
            <div class="column g-props">商品信息</div>
            <div class="column g-price">单价</div>
            <div class="column g-quantity">数量</div>
            <div class="column g-sum">总价</div>
            <div class="column g-action">操作</div>
        </div>
        <div class="carts-goods" id="goodsCart">
            <div class="cell c-images">
                <a href="#" title=""><img src="" alt=""></a>
            </div>
            <div class="cell c-goodsname"><a href="#" title="">名称</a></div>
            <div class="cell c-props">详情</div>
            <div class="cell c-price">
                <span>￥</span>
                <div class="c-pricenum">价格</div>
            </div>
            <div class="cell c-quantity">
                数量
            </div>
            <div class="cell c-sum">
                <span>￥</span>
                <div class="c-sumnum">00.00</div>
            </div>
            <div class="cell c-action">
                <a href="#" class="remove">删除订单</a>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>