/* @description: TODO
   @author 小花妹妹
   @date 2022/11/30 10:50
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
            url:  baseUrl+'/updateCommodity.do?commodityName='+data.field.commodityName+'&commodityPrice='+data.field.commodityPrice+'&commodityStock='+data.field.commodityStock+'&commodityInformation='+data.field.commodityInformation+'&commodityId='+data.field.commodityId,
            type: "post",
            contentType: "application/json;charset=UTF-8",
            // data: JSON.stringify(data.field),
            dataType: 'json',
            success: function(res) {
                // console.log(res);
                layer.close(index);
                if (res.msg == 200) {
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