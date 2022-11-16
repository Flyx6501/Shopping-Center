/* @description: 商品详情
   @author LL
   @date 2022/11/14 10:40
   @version 1.0
*/
window.onload = function() {
    /* 获取货物id */
    var url = window.location.search;
    var id = url.split("=");
    $.ajax({
        /* 获取数据 */
        url: "details.do",
        type: "GET",
        dataType: "json",
        data: {
            "id":id,
        },
        success: function(data) {
            /* 读取成功时将数据读取,显示在页面内 */

            $("#img").html(data.commodityPhoto);
            $("#goodsName").html(data.commodityName);
            $("#props").html(data.commodityInformation);
            $("#price").html(data.commodityPrice);
        }
    });
}
