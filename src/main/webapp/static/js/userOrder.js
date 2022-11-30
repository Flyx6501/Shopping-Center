/* @description: 我的订单操作
   @author LL
   @date 2022/11/17 0:11
   @version 1.0
*/
/* 删除 */
function del(oid) {
    let oname = $("#orderName" + oid).text();
    $("#order" + oid).remove();
    $.ajax({
        url: "#",
        type: "POST",
        dataType: "json",
        data: {
            orderName: oname,
            userName: userName,
            orderId: oid,
        },
        success: function(data) {

        }
    });
}

window.onload = function() {
    /* 返回值给购物车 */
    $.ajax({
        /* 获取全部数据 */
        url: "#",
        type: "GET",
        dataType: "json",
        data: {
             userName: userName,
        },
        success: function(order) {
            /* 读取成功时将数据读取,显示在页面内 */
            let userOrder = $("#userOrder");
            /* 获取订单列表 */
            let k = 0;
            for (k = 0; k < 2; k++) {
                let oid = order[k].orderId;
                let oname = order[k].orderName;
                let onum = order[k].orderNum;
                let oprice = order[k].orderPrice;
                userOrder.append(
                    `<div class="order-list" id="order` + oid + `">
					<input class="input" type="hidden" name="orderId" id="` + oid + `" value="` + oid + `"> 
					<div class="cell c-goodsname" id ="orderName` + oid + `">` + oname + `</div>
					<div class="cell c-price">
						<span>￥</span>
						<div class="c-pricenum" id ="orderPrice` + oid + `">` + oprice + `</div>
					</div>
					<div class="cell c-quantity">` + onum + `</div>
					<div class="cell c-action">
						<a href="#" id="remove" class="remove" onclick="del(` + oid + `)">删除订单</a>
					</div>
				</div>`
                );
            }
        }
    });
}
