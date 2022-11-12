/* @description: TODO
   @author 小花妹妹
   @date 2022/11/8 16:01
   @version 1.0
*/
$(function() {
    var appPath = $("#appPath").val()  //通过隐藏域获取系统根路径
    var flag_username = false;
    var flag_nickname = false;
    var flag_password = false;
    var flag_confirm = false;
    var flag_email = false;

    /* 输入框获取到焦点 清空提示语 */
    $("#userName").focus(function (){
        $("#errorName").html("");
    })
    $("#nickName").focus(function (){
        $("#errorNick").html("");
    })
    $("#password").focus(function (){
        $("#errorPassword").html("");
    })
    $("#confirm").focus(function (){
        $("#errorConfirm").html("");
    })
    $("#email").focus(function (){
        $("#errorEmail").html("");
    })

    //用户名
    $("#userName").blur(function() {

        if ($(this).val().length == 0) {
            //用户名为空
            $("#errorName").html("用户名不为空");
            flag_username = false;
        } else {
            //用户名不为空
            //匹配用户名包含 0-9、a-z、A-Z 长度为 4 到 10 位
            var reg = /^[0-9a-zA-Z]{4,10}$/;
            if (!reg.test($(this).val())) { //用户名格式校验
                $("#errorName").html("用户名需要为4-10个英文字母或数字");
                flag_username = false;
            } else {
                $.ajax({
                    type: 'GET',
                    url: appPath+'/findUserName.do',
                    contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                    data: {
                        userName: $("#userName").val()
                    },
                    dataType:"json",
                    success: function(result) {
                        /* 判断是否已经注册，注册了显示提示语 */
                        let msg = result.msg;
                        if (msg == "failed") {
                            flag_username = false
                            $("#errorName").html('该用户已被注册');
                        } else {
                            flag_username = true;
                        }
                    }
                })
            }
        }
    });

    //昵称
    $("#nickName").blur(function() {
        if ($(this).val().length == 0) {
            //昵称为空
            $("#errorNick").html("昵称不能为空");
            flag_nickname = false;

        } else {
            flag_nickname = true;
        }
    });

    //密码
    $("#password").blur(function() {
        if ($(this).val().length == 0) {
            //密码为空
            $("#errorPassword").html("密码不能为空");
            flag_password = false;

        } else {
            //密码不为空
            //匹配密码包含 0-9、a-z、A-Z 长度为 6 到 15 位
            var reg = /^[0-9a-zA-Z]{6,15}$/;
            if (!reg.test($(this).val())) {
                $("#errorPassword").html("6-15个英文字母或数字");
                flag_password = false;
            } else {
                flag_password = true;
            }
        }
    });

    //确认密码
    $("#confirm").blur(function() {
        if ($(this).val().length == 0) {
            //确认密码为空
            $("#errorConfirm").html("确认密码不为空");
            flag_confirm = false;

        } else {
            //确认密码与输入密码不一致
            if ($(this).val() != $("#password").val()) {
                $("#errorConfirm").html("与密码输入不一致");
                flag_confirm = false;
            } else {
                //密码一致且不为空
                flag_confirm = true;
            }
        }
    });

    //电子邮箱
    $("#email").blur(function() {
        if ($(this).val().length == 0) {
            //电子邮箱为空
            $("#errorEmail").html("电子邮箱不为空");
            flag_email = false;

        } else {
            //电子邮箱格式错误
            var reg = /^\w+@\w+(.\w+)+$/;
            if (!reg.test($(this).val())) {
                $("#errorEmail").html("电子邮箱格式错误");
                flag_email = false;
            } else {
                //电子邮箱格式正确且不为空
                flag_email = true;
            }
        }
    });

    //提交注册
    $("#submit").click(function() {
        if (flag_username && flag_nickname && flag_password && flag_confirm && flag_email) {
            $("form").submit();
            return;
        } else {
            alert("信息未填写完全或有信息填写错误");
        }

        return false;

    });
});

