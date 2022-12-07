<%--
  @description: TODO
  @author: 小花妹妹
  @date: 2022/11/14 1:58
  @version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<head>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css">
	<link rel="stylesheet" href="${APP_PATH}/static/css/managerlogin.css">
	<script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
	<script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
</head>

<div style="padding:20px 20%">
	<input type="hidden" value="${APP_PATH}" id="baseUrl">
	<form class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">ID</label>
			<div class="layui-input-block">
				<input type="text" id="id" name="id" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="20" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" id="userName" name="userName" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="20" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input type="text" id="email" name="email" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="30" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">收货地址</label>
			<div class="layui-input-block">
				<input type="text" id="city" name="city" required lay-verify="required" autocomplete="off" class="layui-input"
					   maxlength="15" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">昵称</label>
			<div class="layui-input-block">
				<input type="text" id="nickname" name="nickname" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="15" >
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="save">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript" src="${APP_PATH}/static/js/customerModify.js"></script>
</body>
</html>
