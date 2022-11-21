/* @description: 商品详情
   @author LL
   @date 2022/11/14 10:40
   @version 1.0
*/
window.onload = function() {
    /* 获取货物id */
    let url = window.location.search;
    let Cid = url.split("=");
    let id = Cid[1];
    console.log(id);
    $.ajax({
        /* 获取数据 */
        url: "commodityDetails.do",
        type: "GET",
        dataType: "json",
        data: {
            id:id,
        },
        success: function(result) {
            /* 读取成功时将数据读取,显示在页面内 */
            /*document.getElementById("img").innerHTML = data.commodityImg;*/
            console.log(result);
            let data = result.commodity;
            console.log(data);
            let Commodity = JSON.parse(data);
            console.log(Commodity);
            document.getElementById("img").innerHTML=Commodity.commodityImg;
            document.getElementById("goodsName").innerHTML=Commodity.commodityName;
            document.getElementById("props").innerHTML=Commodity.commodityInformation;
            document.getElementById("price").innerHTML=Commodity.commodityPrice;
        }
    });

  /*  /!* id传送给购物车 *!/
    function add() {
        /!* Cid为商品id *!/
        window.location.href = "car?Cid=" + id;
    }*/
}
add = function () {

    $.ajax({
        url: "car.do",
        type: "POST",
        dataType: "json",
        data: {
            id: id,
        },
        success: function (data) {
            alert("已加入购物车");

        }
    });
}
