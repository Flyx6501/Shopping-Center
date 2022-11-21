/* @description: 个人信息修改验证
   @author LL
   @date 2022/11/14 0:36
   @version 1.0
*/
$(document).ready(function() {
    /* 昵称 */
    /*    $("#nickName").blur(function() {
            var num = $("#nickName").val().length;
            if (num != 11) {
                showMsg("电话有误");
            }
        });*/
    /* 邮箱 */
    $("#email").blur(function() {
        var reg = /^\w+@\w+(.\w+)+$/;
        if (!reg.test($(this).val())) {
            showMsg("邮箱格式错误");
        } else {
            showMsg("√");
        }
    });


    $("#submit").click(function(){

        /*var model = {
            userName: $("#selfName").val(),
            nickName: $("#nickName").val(),
            email: $("#email").val(),
            address: $("#address").val(),
            userNames:$("#userNames").val(),
        };*/
        $.ajax({
            /* 传入数据接口 */
            url: "userUpdate.do",
            type: "post",
            data: {
                userName: userName,
                nickName: $("#nickName").val(),
                email: $("#email").val(),
                address: $("#address").val(),
                userNames:userName,
            },
            dataType: "json",
            success: function(data) {
                console.log(123);
                showMsg("修改成功!");
                location.reload();
            },
            error: function() {
                console.log(123);
                showMsg("修改失败!")
            }

        });
    });

    function showMsg(msg) {
        $("#checkMsg").text(msg);
    }
});
