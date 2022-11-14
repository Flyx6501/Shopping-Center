/* @description: 个人信息修改验证
   @author LL
   @date 2022/11/14 0:36
   @version 1.0
*/
window.onload = function() {
    $.ajax({
        /* 获取用户名 */
        /*var url = window.location.search;
        var userName = url.split("=");*/
        /* 获取数据列 */
        url: "#",
        type: "GET",
        dataType:"json",
        success: function(data) {
            /* 读取成功时将数据读取,显示在页面内 */
            /*document.getElementById("#selfName").value = data.userName;
            document.getElementById("#phone").value = data.phone;
            document.getElementById("#email").value = data.email;
            document.getElementById("#address").value = data.address;*/
        }
    });
}
$(document).ready(function() {
    /* 电话 */
    $("#phone").blur(function() {
        var num = $("#phone").val().length;
        if (num < 1) {
            showMsg("请输入电话");
        } else if (num > 11) {
            showMsg("电话有误");
        } else {
            showMsg("√");
        }
    });
    /* 邮箱 */
    $("#email").blur(function() {
        var reg = /^\w+@\w+(.\w+)+$/;
        if (!reg.test($(this).val())) {
            showMsg("邮箱格式错误");
        } else {
            showMsg("√");
        }
    });

    function showMsg(msg) {
        $("#checkMsg").text(msg);
    }
});

$("#submit").on("click", function() {
    var model = {
        userName: $("#selfName").val(),
        phone: $("#phone").val(),
        email: $("#email").val(),
        address: $("#address").val(),
    };
    $.ajax({
        /* 传入数据接口 */
        url: "#",
        type: "post",
        data: model,
        dataType: "json",
        success: function(data) {
            BootstrapDialog.show({
                title: "提示",
                message: "修改成功!"
            });
            location.reload();
        },
        error: function() {
            BootstrapDialog.show({
                title: "提示",
                message: "修改失败!"
            });
        }

    });
})