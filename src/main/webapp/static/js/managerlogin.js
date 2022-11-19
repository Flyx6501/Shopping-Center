/* @description: TODO
   @author 小花妹妹
   @date 2022/11/19 14:42
   @version 1.0
*/
window.onload = function () {
    // 获取到主体内容的元素
    var mainEl = $('.home-page')
    $('.layui-nav').delegate('.layui-nav-item a', 'click', function(e) {
        var _id = $(e.target).attr('target')
        mainEl.html('<iframe src="" name="'+_id+'" width="100%" height="100%" frameborder="0"></iframe>')
    })
}