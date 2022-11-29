/* @description: TODO
   @author 小花妹妹
   @date 2022/11/27 20:03
   @version 1.0
*/
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use(['form', 'laydate'], function() {
    var baseUrl = $("#baseUrl").val()
    var form = layui.form,
        laydate = layui.laydate;

    //监听提交
    form.on("submit(save)", function(data) {
        console.log(data, 'data');
        var index = layer.load();
        $.ajax({
            url: baseUrl+'/addCommodity.do?commodityName='+data.field.commodityName+'&commodityPrice='+data.field.commodityPrice+'&commodityStock='+data.field.commodityStock+'&commodityInformation='+data.field.commodityInformation,
            type: "post",
            contentType: "application/json;charset=UTF-8",
            // data: JSON.stringify(data.field),
            dataType: 'json',
            success: function(res) {
                console.log(res);
                if (res.msg == 200) {
                    // 提示新增成功
                    layer.msg("新增成功！");
                    layer.close(index);
                    // 关闭弹窗页面
                    // 刷新表格

                } else {
                    layer.msg("新增失败，请重试！");
                }
            },
            error: function(response) {
                // console.log(response);
                layer.close(index);
                layer.msg("请求出错，请重试!");
            }
        });
        return false;
    });
});