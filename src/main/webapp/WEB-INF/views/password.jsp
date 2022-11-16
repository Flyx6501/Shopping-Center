<%--
  @description: 个人主页-修改密码
  @author: LL
  @date: 2022/11/12 11:00
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
    <title>个人主页</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- Jquery -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css">

    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css">
    <!-- 引入js验证文件-->
    <script type="text/javascript" src="${APP_PATH}/static/js/password.js"></script>
    <!-- 引入css样式-->
    <link rel="stylesheet" href="${APP_PATH}/static/css/password.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<!-- 头部导航 -->
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
            <%--获取用户名--%>
            <div id="userName">
                <%=request.getAttribute("username")%>
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
            <li><a href="${APP_PATH}/userOrder">我的订单</a></li>
            <li class="active"><a href="#">修改密码</a></li>
        </ul>
    </div>
    <!-- obj是用户实体 -->
    <div class="layui-col-md10">
        <!-- 修改密码 -->
        <div id="edit-password">
            <form action="#" method="post" id="myself">
                <!-- 表单整体 -->
                <div class="whole">
                    <!-- 基本信息显示条 -->
                    <div class="new-password">
                        修改密码
                    </div>
                    <!-- 旧密码 -->
                    <input type="hidden" id="password" value="${obj.passWord}">
                    <div class="layui-row">
                        <!-- 属性名 -->
                        <div class="layui-col-md2">
                            <div class="font">
                                旧密码
                                <font class="red">*</font>
                            </div>
                        </div>
                        <!-- input -->
                        <div class="layui-col-md10">
                            <input class="input" type="password" id="oldPassword" name="oldPassword" required="required">
                        </div>
                    </div>
                    <!-- 新密码 -->
                    <div class="layui-row">
                        <!-- 属性名 -->
                        <div class="layui-col-md2">
                            <div class="font">
                                新密码
                                <font class="red">*</font>
                            </div>
                        </div>
                        <!-- input -->
                        <div class="layui-col-md10">
                            <input class="input" type="password" id="firstPassword" name="firstPassword" required="required">
                        </div>
                    </div>
                    <!-- 确认密码 -->
                    <div class="layui-row">
                        <!-- 属性名 -->
                        <div class="layui-col-md2">
                            <div class="font">
                                确认密码
                                <font class="red">*</font>
                            </div>
                        </div>
                        <!-- select -->
                        <div class="layui-col-md10">
                            <input class="input" type="password" id="secondPassword" name="secondPassword" required="required">
                        </div>
                    </div>
                    <div class="update">
                        <button type="button" id="btn" class="submit">确认修改</button>
                        <!-- <a href="#" class="submit">保存</a> -->
                    </div>
                    <div id="checkMsg" class="msg"></div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>