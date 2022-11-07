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
    <div class="rg_left"><p>用户注册</p></div>
    <!-- 定义表单form -->
    <form action="#" method="post" >
        <table>
            <tr>
                <td class="td_left"><label for="userName">用户名</label></td>
                <td class="td_center"><input id="userName" type="text" placeholder="4-10个英文字母或数字" ></td>
                <td class="td_right"><label id="errorName" class="errstyle"></label></td>
            </tr>

            <tr>
                <td class="td_left"><label for="nickName">昵称</label></td>
                <td class="td_center"><input id="nickName" type="text" placeholder="昵称不能为空" ></td>
                <td class="td_right"><label id="errorNick" class=" errstyle"></label></td>
            </tr>

            <tr>
                <td class="td_left"><label for="password">密码</label></td>
                <td class="td_center"><input id="password" type="password" placeholder="6-15个英文字母或数字" ></td>
                <td class="td_right"><label id="errorPassword" class="errstyle"></label></td>
            </tr>

            <tr>
                <td class="td_left"><label for="confirm">确认密码</label></td>
                <td class="td_center"><input id="confirm" type="password" placeholder="确认密码" ></td>
                <td class="td_right"><label id="errorConfirm" class="errstyle"></label></td>
            </tr>
            <tr>
                <td class="td_left"><label for="email">电子邮箱</label></td>
                <td class="td_center"><input type="email" id="email" placeholder="电子邮箱" ></td>
                <td class="td_right"><label id="errorEmail" class="errstyle"></label></td>
            </tr>

        </table>
        <div class="btn_sub"><button class="btn" id="submit">注册</button></div>
        <div class="rg_right"><p>已有账号?<a href="#">立即登录</a></p></div>
    </form>
</div>

</body>
</html>
