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
        //console.log(data, 'data');
        var formdata = new FormData()
        formdata.append('commodityName',data.field.commodityName)
        formdata.append('commodityPrice',data.field.commodityPrice)
        formdata.append('commodityStock',data.field.commodityStock)
        formdata.append('commodityInformation',data.field.commodityInformation)
        formdata.append('commodityPhoto',data.form[4].files[0])
        $.ajax({
            url: baseUrl+'/addCommodity.do',
            type: "post",
            contentType : false,
            processData : false,
            // contentType: "application/json;charset=UTF-8",
            data:formdata,
            // dataType: 'json',
            async: false,
            success: function(res) {
                //console.log(res);
                if (res.msg == 200) {
                    layer.msg("新增成功", {
                        icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        //do sometaddCommodity.dohing
                        window.parent.location.reload();//刷新父页面
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    });

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