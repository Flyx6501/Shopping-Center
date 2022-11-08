//验证表单是否为空，为空则聚焦input并提示；不为空则进行下一步表单验证
function check(form) {
  var AdminName = $("#AdminName").val();
  var password = $("#password").val();
  //用户名为空
  if (!AdminName || AdminName == "") {
    showMsg("请输入用户名");
    //聚焦
    form.AdminName.focus();
    //禁止默认行为
    return false;
  }
  //密码为空
  if (!password || password == "") {
    showMsg("请输入密码");
    form.password.focus();
    return false;
  }
  //验证账号密码是否存在且正确
  $.ajax({
    url: "#",// 后台接口
    data: { "password": password, "AdminName": AdminName },
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
        else if (data.msg == "1") {
          setTimeout(function () {//延时显示登录状态
            showMsg("正在登录中...");
            window.location.href = url;//当前页面打开此url
          }, 100)//指定等候时间为100
          return false;
        }
      }
    },
    error: function (data) {
      alert("登录失败，请重试");
    }
  });
}

//错误信息提醒
function showMsg(msg) {
  $("#CheckMsg").text(msg);
}
