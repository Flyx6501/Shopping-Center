<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员登录界面</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- Jquery -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css">
</head>
<html>
<body>

<script src="./js/admin.js"></script>
<div class="content">
    <div class="login-wrap">
        <!-- 接入跳转页面 -->
        <form id="user_login" action="">
            <h3>后 台 登 录</h3>
            <input class="name" name="" id="AdminName" type="text" placeholder="请输入用户名">
            <input class="pwd" name="password" id="password" type="password" placeholder="请输入密码">
            <div class="btn">
                <input type="button" id="sbt" class="sbt" value="登录" onclick="return check(this.form);">
                <input type="reset" id="reset" class="reset" value="重置">
            </div>
            <div id="CheckMsg" class="msg"></div>
        </form>
    </div>
</div>
</body>
</html>
