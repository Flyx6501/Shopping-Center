<%--
  @description: 管理员登录界面
  @author: 86188
  @date: 2022/11/9 21:43
  @version: 1.0
--%>
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
    <!-- 引入js验证文件-->
    <script type="text/javascript" src="${APP_PATH}/static/js/admin.js"></script>
    <!-- 引入css样式-->
    <link rel="stylesheet" href="${APP_PATH}/static/css/admin.css">
</head>
<html>
<body>

<div class="content">
    <div class="login-wrap">
        <!-- 接入跳转页面 -->
        <form id="adminLogin" action="managerLogin.do">
            <h3>后 台 登 录</h3>
            <input class="name" name="" id="adminName" type="text" placeholder="请输入用户名" onblur="checkAdminName(this.value)">
            <input class="pwd" name="password" id="password" type="password" placeholder="请输入密码" onblur="checkPassWord(this.value)">
            <div class="btn">
                <input type="submit" id="submitBtn" class="submit-btn" value="登录" onclick="return check(this.form);">
                <input type="reset" id="resetBtn" class="reset-btn" value="重置">
            </div>
            <div id="checkMsg" class="msg"></div>
        </form>
    </div>
</div>
</body>
</html>
