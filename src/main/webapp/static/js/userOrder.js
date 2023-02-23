/* @description: 我的订单操作
   @author LL
   @date 2022/11/17 0:11
   @version 1.0
*/
/* 删除 */
function del(oid,cid) {
    let oname = $("#orderName" + oid).text();
    $("#order" + oid).remove();
    //console.log(oid);
    //console.log(cid);
    //console.log(oname);
    $.ajax({
        url: "deleteOrderServlet",
        type: "POST",
        dataType: "json",
        data: {
            commodityName: oname,
            userName: userName,
            orderId: oid,
            commodityId: cid,
        },
        success: function(data) {
            alert("删除成功");
        }

    });
}

window.onload = function() {
    /* 返回值给购物车 */
    $.ajax({
        /* 获取全部数据 */
        url: "getOrderServlet",
        type: "GET",
        dataType: "json",
        data: {
             userName: userName,
        },
        success: function(data) {
            /* 读取成功时将数据读取,显示在页面内 */
            console.log(data);
            let order = data.order;
            console.log(order);
            let userOrder = $("#userOrder");
            /* 获取订单列表 */
            let k = 0;
            var length = order.length;
            console.log(length);
            for (k = 0; k < length; k++) {
                var oid = order[k].orderId;
                let cid = order[k].commodityId;
                let oname = order[k].commodityName;
                let onum = order[k].commodityNum;
                let oprice = order[k].commodityPrice;
                userOrder.append(
                    `<div class="order-list" id="order` + oid + `">
                    <input class="input" type="hidden" name="commodityId" id="` + cid +`" value="` + cid + `">
					<input class="input" type="hidden" name="orderId" id="` + oid + `" value="` + oid + `"> 
					<div class="cell c-goodsname" id ="orderName` + oid + `">` + oname + `</div>
					<div class="cell c-price">
						<span>￥</span>
						<div class="c-pricenum" id ="orderPrice` + oid + `">` + oprice + `</div>
					</div>
					<div class="cell c-quantity">` + onum + `</div>
					<div class="cell c-action">
						<a href="#" id="remove" class="remove" onclick="del(` + oid + `,` + cid + `)">删除订单</a>
					</div>
				</div>`
                );
            }
        }
    });
}
