/* @description: 管理员登录验证
   @author 86188
   @date 2022/11/9 21:43
   @version 1.0
*/
//验证表单是否为空，为空则聚焦input并提示；不为空则进行下一步表单验证
function checkAdminName (adminName) {
    var adminName = $("#adminName").val();
    if (adminName == '') {
        showMsg("请输入用户名");
        return false;
    }
}
function checkPassWord (password) {
    var password = $("#password").val();
    if (password == '') {
        showMsg("请输入密码");
        return false;
    }
}
function check(form) {
    var adminName = $("#adminName").val();
    var password = $("#password").val();
    //验证账号密码是否存在且正确
    $.ajax({
        url: "#",// 后台接口
        data: {
            password: password,
            adminName: adminName
        },
        type: "GET",
        dataType: "json",
        //data 默认参数
        success: function (data) {
            if (data) {
                //判断返回值，后端接入
                if (data.msg == "2") {//账号密码错误时的返回值
                    alert("用户名或密码错误");
                    window.location.reload();//页面重载
                }
            }
        }
    });
}

//错误信息提醒
function showMsg(msg) {
    $("#checkMsg").text(msg);
}
