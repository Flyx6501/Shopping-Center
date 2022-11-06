<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新用户注册界面</title>
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
<div class="container">

    <h1>用户注册</h1>

    <form action="#" method="post" >
        <div class="form-group">

            <label for="userName" class="col-md-2">
                <span>用户名</span><b>*</b>
            </label>

            <div class="col-md-3">
                <input id="userName" type="text" placeholder="4-10个英文字母或数字" >
            </div>

            <div class="col-md-4">
                <label id="errorName" class=" errstyle"></label>
            </div>

        </div>

        <div class="form-group">

            <label for="nickName" class="col-md-2 ">
                <span>昵称</span><b>*</b>
            </label>

            <div class="col-md-3">
                <input id="nickName" type="text" placeholder="昵称不能为空" >
            </div>

            <div class="col-md-4">
                <label id="errorNick" class=" errstyle"></label>
            </div>

        </div>


        <div class="form-group">

            <label for="password" class="col-md-2 ">
                <span>密码</span><b>*</b>
            </label>

            <div class="col-md-3">
                <input id="password" type="password" placeholder="8-16个英文字母或数字" >
            </div>

            <div class="col-md-4">
                <label id="errorPassword" class="errstyle"></label>
            </div>

        </div>


        <div class="form-group">
            <label for="confirm" class="col-md-2 ">
                <span>确认密码</span><b>*</b>
            </label>

            <div class="col-md-3">
                <input id="confirm" type="password" placeholder="确认密码" >
            </div>

            <div class="col-md-4">
                <label id="errorConfirm" class="errstyle"></label>
            </div>

        </div>



        <div class="form-group">
            <label for="email" class="col-md-2">
                <span>电子邮箱</span>
            </label>
            <div class="col-md-3">
                <input type="email" id="email" placeholder="电子邮箱" >
            </div>
            <div class="col-md-4">
                <label id="errorEmail" class="errstyle"></label>
            </div>
        </div>

        <div class="col-md-1">
            <button class="btn" id="submit">提交</button>

        </div>

    </form>
</div>

</body>
</html>
