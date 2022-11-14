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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/details.js"></script>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/layui-2.6.8.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/details.css" />
    <title>详情</title>
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
            <a href="">购物车</a>
        </div>
        <div class="layui-col-md1">
            <div id="userName">

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
                <h3 id="goodsName">web开发与应用</h3>
            </div>
            <div class="news">
                <div class="d-props" id="props">
                    开发与应用，适合学习前端开发，html5+css
                </div>
            </div>
            <div class="d-price">
                <span>￥</span>
                <div class="d-pricenum" id="price">32.80</div>
            </div>
            <div class="add-cart">
                <a href="#">加入购物车</a>
            </div>
        </div>
    </div>
</div>
<script>
    show();
    /* ./json/details. 数据接口 */
    function show(){
        $.getJSON("./json/details.json",function(data){
            $("#goodsName").html(data.goodsName);
            $("#props").html(data.props);
            $("#price").html(data.price);
        })
    }
</script>
</body>
</html>