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
    /*console.log(id);*/
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
            /*console.log(result);*/
            let data = result.commodity;
            //console.log(data);
            //console.log(data[0].commodityPhoto);
            //console.log(img);
            let imgSrc = data[0].commodityPhoto;
            //console.log(imgSrc);
            document.getElementById("photo").innerHTML = "<img src ='" + imgSrc +"' height='400' width='300'>";
            document.getElementById("goodsName").innerHTML=data[0].commodityName;
            //console.log(data[0].commodityName);
            document.getElementById("props").innerHTML=data[0].commodityInformation;
            document.getElementById("price").innerHTML=data[0].commodityPrice;
        }
    });
}

