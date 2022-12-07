/* @description: TODO
   @author 小花妹妹
   @date 2022/12/1 19:47
   @version 1.0
*/
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use(['form', 'laydate'], function() {
    var baseUrl = $("#baseUrl").val()
    var form = layui.form,
        laydate = layui.laydate;

    //监听提交
    form.on("submit(save)", function(data) {
        var index = layer.load();
        $.ajax({
            url: baseUrl + '/updateManager.do?userName=' + data.field.userName + '&address=' + data.field.city + '&email=' + data.field.email + '&nickName=' + data.field.nickname + '&Id=' + data.field.id,
            type: "post",
            contentType: "application/json;charset=UTF-8",
            dataType: 'json',
            async: false,
            success: function(res) {
                //console.log(res);
                if (res.msg == 'success') {
                    layer.msg("编辑成功", {
                        icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        //刷新父页面
                        window.parent.location.reload();
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    });
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