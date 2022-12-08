<%--
  @description: TODO
  @author: 小花妹妹
  @date: 2022/11/14 2:00
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
<body>
<div style="padding:20px 20%">
	<input type="hidden" value="${APP_PATH}" id="baseUrl">
	<form class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称</label>
			<div class="layui-input-block">
				<input type="text" name="commodityName" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="20" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品价格</label>
			<div class="layui-input-block">
				<input type="text" name="commodityPrice" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="30" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">库存</label>
			<div class="layui-input-block">
				<input type="text" name="commodityStock" required lay-verify="required" autocomplete="off" class="layui-input"
					   maxlength="15" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品描述</label>
			<div class="layui-input-block">
				<input type="text" name="commodityInformation" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="15" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品图片</label>
			<div class="layui-input-block">
				<input type="file" name="commodityPhoto" required lay-verify="required" autocomplete="off"
					   class="layui-input" accept="image/">
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

<script type="text/javascript" src="${APP_PATH}/static/js/commodityAdd.js"></script>

</body>
</html>
