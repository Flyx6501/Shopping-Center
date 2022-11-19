/* @description: 商品详情
   @author LL
   @date 2022/11/14 10:40
   @version 1.0
*/
window.onload = function() {
    /* 获取货物id */
    var url = window.location.search;
    var commodityId = url.split("=");
    /*console.log(commodityId);*/
    $.ajax({
        /* 获取数据 */
        url: "CommodityGetOneServlet",
        type: "GET",
        dataType: "json",
        data: {
            "commodityId":commodityId,
        },
        success: function() {
            /* 读取成功时将数据读取,显示在页面内 */
            $("#img").html(data.commodityPhoto);
            $("#goodsName").html(data.commodityName);
            $("#props").html(data.commodityInformation);
            $("#price").html(data.commodityPrice);
        }
    });

    /* id传送给购物车 */
    function add() {
        /* Cid为商品id */
        window.location.href = "car?Cid=" + id;
    }

    $.ajax({
        /* 获取数据 */
        url: "car.do",
        type: "POST",
        dataType: "json",
        data: {
            "commodityId": commodityId,
        },
        success: function(data) {
            /* 数据存入购物车 */

        }
    });
}
