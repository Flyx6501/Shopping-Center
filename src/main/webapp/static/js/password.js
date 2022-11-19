/* @description: 个人主页-修改密码
   @author LL
   @date 2022/11/12 11:06
   @version 1.0
*/
$(document).ready(function() {
    $("#oldPassword").blur(function() {
        var oldPassword = $("#oldPassword").val();
        if(oldPassword == ''){
            showMsg("请输入原密码");
        }
        else{
            /* 判断原密码是否正确 */
            $.ajax({
                url: "searchPasswordByUserName.do",
                type: "post",
                data: {
                    userName:userName,
                    password:oldPassword,
                },
                dataType:"json",
                success: function(res) {
                    let msg = res.msg;
                    if (msg == "success") {
                        showMsg("√");
                    } else {
                        showMsg("原密码输入错误");
                    }
                }
            });
        }
    });
    $("#firstPassword").blur(function() {
        var num = $("#firstPassword").val().length;
        if (num < 6) {
            showMsg("密码过短");
        } else if (num > 10) {
            showMsg("密码过长");
        } else {
            showMsg("√");
        }
    });
    $("#secondPassword").blur(function() {
        var num = $("#secondPassword").val().length;
        var firstPassword = $("#firstPassword").val();
        var secondPassword = $("#secondPassword").val().length;
        if ($("#secondPassword").val() != firstPassword) {
            showMsg("与新密码不相同");
        } else {
            if (num >= 6 && num <= 10) {
                showMsg("√");
            } else {
                showMsg("密码不符合规则，密码长度应为6-10个字母或数字");
            }
        }
    });
    $("#btn").click(function() {
        var flag = true;
        /*alert(userName)*/
        var oldPassword = $("#oldpassword").val();
        var firstPassword = $("#firstPassword").val();
        var password = $("#secondPassword").val();
        var first = $("#firstPassword").val().length;
        var second = $("#secondPassword").val().length;
        if (first != second || first < 6 || second < 6 || first > 10 || second > 10 || firstPassword !=
            password) {
            flag = false;
        } else {
            flag = true;
        }
        if (flag) {
            /* 修改密码 */
            $.ajax({
                url: "updatePasswordByUserName.do",
                type: "post",
                data: {
                    /* password: oldpassword,*/
                    userName: userName,
                    password: password,

                },
                dataType:"json",
                /* 成功则清空输入框 */
                success: function() {
                    /* console.log(data);*/
                    alert("修改成功");
                    $("#oldpassword").val("");
                    $("#firstPassword").val("");
                    $("#secondPassword").val("");
                    $("#oldPassword").empty();
                    $("#firstPassword").empty();
                    $("#secondPassword").empty();
                }
            });
        }
    });
    //错误信息提醒
    function showMsg(msg) {
        $("#checkMsg").text(msg);
    }
});

