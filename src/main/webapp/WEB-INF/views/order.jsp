<%--
  @description: TODO
  @author: 小花妹妹
  @date: 2022/11/14 2:01
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
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">商城后台管理系统</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="${APP_PATH}/static/img/pic1.jpg" class="layui-nav-img">
                    admin
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
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="${APP_PATH}/commodity">商品管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${APP_PATH}/customer">用户管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${APP_PATH}/order">订单管理</a>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="home-page">
            <script type="text/html" id="toolbarDemo">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">用户名称</label>
                            <div class="layui-input-inline">
                                <!--注意此处input标签里的id-->
                                <input class="layui-input" name="keyword" id="keyword" autocomplete="off">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <!--注意此处button标签里的type属性-->
                            <button class="layui-btn layui-btn-primary" lay-event="search"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </script>

            <!-- <div class="layui-btn-group demoTable">
              <button class="layui-btn" id="add">新增</button>
            </div> -->
            <!-- 顾客信息数据表格 -->
            <table id="demo" lay-filter="test" lay-data="{id: 'test'}"></table>
            <!-- <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script> -->
            <script type="text/javascript">
                layui.use('table', function() {
                    var table = layui.table;

                    //加载table实例
                    table.render({
                        // elem属性用来绑定容器的id属性值
                        elem: '#demo',
                        height: 500,
                        toolbar: '#toolbarDemo',
                        //url接口地址。
                        //默认会自动传递两个参数：?page=1&limit=30(该参数可通过request自定义)，page代表当前页码、limit代表每页数据量
                        url: '${APP_PATH}/static/js/order.json',
                        //开启分页
                        page: true,
                        cols: [[
                            {type: 'checkbox', fixed: 'left'},
                            {field: 'order_id',title: 'ID',width: 100, fixed: 'left'},
                            {field: 'username',title: '用户名',width: 200},
                            {field: 'com_name',title: '商品名称',width: 230},
                            {field: 'com_num',title: '商品数量',width: 250},
                            {field: 'com_price',title: '价格',width: 230},
                            // {field: 'operate',title: '操作',width: 200, toolbar: '#barDemo', width:150},
                        ]],
                    });
                });
            </script>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>
<script type="text/javascript" src="${APP_PATH}/static/js/order.js"></script>

</body>
</html>