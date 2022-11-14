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
	<form class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" id="username" name="username" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="20" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input type="text" id="email" name="email" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="30" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">收货地址</label>
			<div class="layui-input-block">
				<input type="text" id="city" name="city" required lay-verify="required" autocomplete="off" class="layui-input"
					   maxlength="15" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">昵称</label>
			<div class="layui-input-block">
				<input type="text" id="nickname" name="nickname" required lay-verify="required" autocomplete="off"
					   class="layui-input" maxlength="15" value="">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="save">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
		<input type="hidden" id="id" name="id" value="">
	</form>
</div>

<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use(['form', 'laydate'], function() {
        var form = layui.form,
            laydate = layui.laydate;

        //监听提交
        form.on("submit(save)", function(data) {
            var index = layer.load();
            $.ajax({
                url: "/user/modify",
                type: "post",
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(data.field),
                dataType: 'json',
                success: function(res) {
                    console.log(res);
                    layer.close(index);
                    if (res.data == 200) {
                        layer.msg("编辑成功！");
                    } else {
                        layer.msg("编辑失败，请重试！");
                    }
                },
                error: function(response) {
                    console.log(response);
                    layer.close(index);
                    layer.msg("请求出错，请重试!");
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
