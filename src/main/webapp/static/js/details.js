/* @description: 商品详情
   @author LL
   @date 2022/11/14 10:40
   @version 1.0
*/
window.onload = function() {
    $.ajax({
        /* 获取货物名 */
        /* var url = window.location.search;
        var goodsName = url.split("="); */
        /* 获取数据 */
        url: "#",
        type: "GET",
        dataType: "json",
        data: {
            "id": id
        },
        success: function () {
            /* 读取成功时将数据读取,显示在页面内 */
        }
    })
}
