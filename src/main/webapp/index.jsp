<%--
  @description: 前台首页界面
  @author: LL
  @date: 2022/11/12 17:35
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
    <title>首页</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!--定义绝对路径-->
    <script type="text/javascript">
        let APP_PATH=${APP_PATH};
    </script>
    <!--定义用户名变量-->
    <script type="text/javascript">
        let userName = "<%=session.getAttribute("userName")%>";
    </script>
    <!-- Jquery -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <!-- layui -->
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8.js"></script>
    <!-- 引入js验证文件-->
    <script type="text/javascript" src="${APP_PATH}/static/js/index.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/bootstrap-3.4.1-dist.min.css" />
    <!-- layui -->
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8.css" />
    <!-- 引入css样式-->
    <link rel="stylesheet" href="${APP_PATH}/static/css/index.css" />
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<!-- 头部导航栏-->
<div class="nav-bar">
    <div class="layui-row">
        <!-- 登录/注册 -->
        <div class="layui-col-md8">
            <a href="${APP_PATH}/login">登录</a>
            <span>/</span>
            <a href="${APP_PATH}/register">注册</a>
        </div>
        <div class="layui-col-md2">
        </div>
        <div class="layui-col-md2">
        </div>
    </div>
</div>
<!-- 整体留白布局 -->
<div class="layui-container">
    <div class="layui-row layui-col-space10">
        <div class="layui-col-md2">
            <!-- 圆形图片 -->
            <img src="https://tvax3.sinaimg.cn/crop.0.0.1080.1080.180/007e4nGQly8gkzng7wnouj30u00u0q41.jpg?KID=imgbed,tva&Expires=1667993690&ssig=0nfJ3J6I9X"
                 alt="..." class="img-circle">
        </div>
        <div class="layui-col-md10">
            <div class="layui-col-md10">
                <input type="text" name="find" id="find" lay-verify="title" autocomplete="off"
                       placeholder="搜索" class="layui-input">
            </div>
            <div class="layui-col-md2">
                <button type="button" id="search" class="layui-btn layui-btn-danger layui-btn-radius"
                        onclick="checkSearch()">
                    搜索
                    <i class="layui-icon layui-icon-search" style="color: #fff;"></i>
                </button>
            </div>
        </div>
    </div>
    <!-- 分类+（轮播+活动专区） -->
    <h3>分类</h3>
    <div class="layui-row layui-col-space10">
        <div class="layui-row layui-col-space8">
            <div class="layui-col-md2">
                <!-- 分类 -->
                <ul class="left-nav">
                    <li class="active"><a href="${APP_PATH}/sort">服装</a></li>
                    <li><a href="#">鞋包</a></li>
                    <li><a href="#">食品</a></li>
                    <li><a href="#">电子产品</a></li>
                    <li><a href="#">百货</a></li>
                </ul>
            </div>
            <div class="layui-col-md10">
                <!-- 轮播 -->
                <div class="layui-row">
                    <div class="layui-carousel" id="test1">
                        <div carousel-item>
                            <div>
                                <img src="" />
                            </div>
                            <div>
                                <img src="" />
                            </div>
                            <div>
                                <img src="" />
                            </div>
                            <div>
                                <img src="" />
                            </div>
                            <div>
                                <img src="" />
                            </div>
                        </div>
                    </div>
                    <!-- 轮播图js -->
                    <script>
                        layui.use('carousel', function() {
                            var carousel = layui.carousel;
                            /*建造实例*/
                            carousel.render({
                                elem: '#test1',
                                width: '100%',//设置容器宽度
                                arrow: 'always' //始终显示箭头
                                //,anim: 'updown' //切换动画方式
                            });
                        });
                    </script>
                </div>
            </div>
        </div>
        <!-- 活动专区 -->
        <h3>活动专区</h3>
        <div id="products">

        </div>
    </div>
</div>
<script>
    layui.use('element', function() {
        var element = layui.element;
       /* 一些事件触发*/
        element.on('tab(demo)', function(data) {
            console.log(data);
        });
    });
</script>
</body>
</html>