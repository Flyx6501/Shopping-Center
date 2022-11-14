<%--
  @description: TODO
  @author: 86188
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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/car.js"></script>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/layui-2.6.8.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/car.css" />
    <title>购物车</title>
</head>
<body>
<!-- 头部导航 -->
<div class="nav-bar">
    <div class="layui-row">
        <!-- 返回首页 -->
        <div class="layui-col-md8">
            <a href="${APP_PATH}/index">返回首页</a>
        </div>
        <div class="layui-col-md2">
            <a href="${APP_PATH}/self">个人中心</a>
        </div>
    </div>
</div>
<!-- 留白布局 -->
<div class="layui-container">
    <div class="cart">
        <div class="cart-head">
            <div class="column g-select">
                <div class="g-checkbox">
                    <input type="checkbox" class="all each">
                </div>
                全选
            </div>
            <div class="column g-images">图片</div>
            <div class="column g-goodsname">商品名称</div>
            <div class="column g-props">商品信息</div>
            <div class="column g-price">单价</div>
            <div class="column g-quantity">数量</div>
            <div class="column g-sum">小计</div>
            <div class="column g-action">操作</div>
        </div>

        <c:forEach items="${carList}" var="item">
            <div class="carts-goods">
                <div class="cell c-select">
                    <div class="c-checkbox">
                        <input type="checkbox" class="each">
                    </div>
                </div>
                <div class="cell c-images">
                    <a href="#" title=""><img src="" alt="图片"></a>
                </div>
                <div class="cell c-goodsname"><a href="#" title="">名称</a></div>
                <div class="cell c-props">详情</div>
                <div class="cell c-price">
                    <span>￥</span>
                    <div class="c-pricenum">价格</div>
                </div>
                <div class="cell c-quantity">
                    <button type="button"  class="reduce">-</button>
                    <input type="text" value="数量" class="text-num" value="1">
                    <button type="button" class="add">+</button>
                </div>
                <div class="cell c-sum">
                    <span>￥</span>
                    <div class="c-sumnum">总价</div>
                </div>
                <div class="cell c-action">
                    <a href="#" class="remove">移除商品</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="payment">
        <div class="cart-pay">
            <div class="pay-left">
                <div class="select-all">
                    <input type="checkbox" class="all each">
                    全选
                </div>
                <div class="goods-num">
                    已选择数量:
                    <span>0</span>
                    件
                </div>
            </div>
            <div class="pay-right">
                <div class="right-compute">
                    <div class="btn">
                        <!-- 结算页 -->
                        <a href="#">结算</a>
                    </div>
                    <div class="price-sum">
                        <div class="price-show">总价是：</div>
                        <div class="show-money">
                            ￥
                            <span>00.00</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>