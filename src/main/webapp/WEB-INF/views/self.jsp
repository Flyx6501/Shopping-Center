<%--
  @description: 个人信息
  @author: LL
  @date: 2022/11/14 0:29
  @version: 1.0
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
    <!--定义绝对路径-->
    <script type="text/javascript">
        let APP_PATH=${APP_PATH};
    </script>
    <!--定义用户名-->
    <script type="text/javascript">
        let userName = "<%=session.getAttribute("userName")%>";
    </script>
    <!-- Jquery -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <!-- layui -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
    <!-- 引入js验证文件-->
    <script type="text/javascript" src="${APP_PATH}/static/js/self.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css">
    <!-- layui -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css">
    <!-- 引入css样式-->
    <link rel="stylesheet" href="${APP_PATH}/static/css/self.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<!-- 头部导航 -->
<div class="nav-bar">
    <div class="layui-row">
        <div class="layui-col-md6">
            <div>个人中心</div>
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
    <div class="layui-col-md2">
        <!-- 分类 -->
        <ul class="left-nav">
            <li class="active"><a href="#">个人信息</a></li>
            <li><a href="${APP_PATH}/userOrder">我的订单</a></li>
            <li><a href="${APP_PATH}/password">修改密码</a></li>
        </ul>
    </div>
    <div class="layui-col-md10">
        <!-- 修改个人信息 -->
        <div id="editMyself">
            <!-- 传入后端修改值 -->
            <form action="#" method="post" id="myself">
                <!-- 表单整体 -->
                <div class="whole">
                    <!-- 基本信息显示条 -->
                    <div class="information">
                        个人信息
                    </div>
                    <!-- 真实姓名 -->
                    <div class="layui-row">
                        <!-- 属性名 -->
                        <div class="layui-col-md2">
                            <div class="font">
                                姓名
                                <font class="red">*</font>
                            </div>
                        </div>
                        <!-- input -->
                        <div class="layui-col-md10">
                            <input class="input" type="text" name="userName" id="selfName" value="${userName}">
                        </div>
                    </div>
                    <div class="layui-row">
                        <!-- 属性名 -->
                        <div class="layui-col-md2">
                            <div class="font">
                                昵称
                                <font class="red">*</font>
                            </div>
                        </div>
                        <!-- input -->
                        <div class="layui-col-md10">
                            <input class="input" type="text" name="nickName" id="nickName" value="${nickName}">
                        </div>
                    </div>
                    <!-- 邮箱 -->
                    <div class=" layui-row">
                        <!-- 属性名 -->
                        <div class="layui-col-md2">
                            <div class="font">
                                邮箱
                                <font class="red">*</font>
                            </div>
                        </div>
                        <!-- input -->
                        <div class="layui-col-md10">
                            <input class="input" type="text" name="email" id="email" value="${email}">
                        </div>
                    </div>
                    <div class="layui-row">
                        <div class="layui-col-md2">
                            <div class="font">
                                地址
                                <font class="red">*</font>
                            </div>
                        </div>
                        <!-- input -->
                        <div class="layui-col-md10">
                            <input class="input" type="text" name="address" id="address" value="${address}">
                        </div>
                    </div>
                    <!-- 隐藏用户名-->
                    <div class="layui-row">
                        <!-- 属性名 -->
                        <div class="layui-col-md2">
                            <div class="font">

                                <font class="red"></font>
                            </div>
                        </div>
                        <!-- input -->
                        <div class="layui-col-md10">
                            <input class="input" type="hidden" name="userName" id="userName2" value="${userName}">
                        </div>
                    </div>
                    <!--保存-->
                    <div class="save">
                        <button type="button" class="submit" id="submit">保存</button>
                    </div>
                    <div id="checkMsg" class="msg"></div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
