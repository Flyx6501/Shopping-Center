<%--
  @description: TODO
  @author: 小花妹妹
  @date: 2022/11/8 15:53
  @version: 1.0
--%>
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
    <%--引入css样式--%>
    <link rel="stylesheet" href="${APP_PATH}/static/css/register.css">
    <%--引入js--%>
    <script type="text/javascript" src="${APP_PATH}/static/js/register.js"></script>
</head>
<html>
<body>
<div class="container">
    <div class="rg-left">
        <p>用户注册</p>
    </div>
    <!-- 定义表单form -->
    <form action="${APP_PATH}/userRegister.do" method="post">
        <table>
            <tr>
                <td class="td-left"><label for="userName">用户名</label></td>
                <td class="td-center"><input id="userName" name="userName" placeholder="4-10个英文字母或数字"></td>
                <td class="td-right"><label id="errorName" class="err-style"></label></td>
            </tr>

            <tr>
                <td class="td-left"><label for="nickName">昵称</label></td>
                <td class="td-center"><input id="nickName" name="nickName" type="text" placeholder="昵称不能为空">
                </td>
                <td class="td-right"><label id="errorNick" class=" err-style"></label></td>
            </tr>

            <tr>
                <td class="td-left"><label for="password">密码</label></td>
                <td class="td-center"><input id="password" name="password" type="password"
                                             placeholder="6-15个英文字母或数字"></td>
                <td class="td-right"><label id="errorPassword" class="err-style"></label></td>
            </tr>

            <tr>
                <td class="td-left"><label for="confirm">确认密码</label></td>
                <td class="td-center"><input id="confirm" name="confirm" type="password" placeholder="确认密码">
                </td>
                <td class="td-right"><label id="errorConfirm" class="err-style"></label></td>
            </tr>
            <tr>
                <td class="td-left"><label for="email">电子邮箱</label></td>
                <td class="td-center"><input type="email" id="email" name="email" placeholder="电子邮箱"></td>
                <td class="td-right"><label id="errorEmail" class="err-style"></label></td>
            </tr>

        </table>
        <div class="btn-sub"><input type="submit" class="btn" id="submit" name="submit" value="注册"></div>
        <div class="rg-right">
            <p>已有账号?<a href="${APP_PATH}/login">立即登录</a></p>
        </div>
    </form>
</div>

</body>
</html>
