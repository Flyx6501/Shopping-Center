/* @description: 购物车操作
   @author LL
   @date 2022/11/14 10:15
   @version 1.0
*/
/* 减数量 */
function reduce(cid, sum) {
    /* 最初数量 */
    var num = $("#commodityNum" + cid).val();
    if (num > 0) {
        num--;
        $("#commodityNum" + cid).val(num);
    };
    var price = $("#commodityPrice" + cid).text();
    sum = parseFloat(price * num);
    /* 保留一位 */
    function math() {
        sum = Math.round(sum * 100) / 100;
    }
    math();
    $("#commoditySum" + cid).text(sum);
    var id = cid;
    let cname = $("#commodityName" + cid).text();
    let cnum = $("#commodityNum" + cid).val();
    $.ajax({
        url: "updateCar.do",
        type: "POST",
        dataType: "json",
        data: {
            commodityId: id,
            commodityName: cname,
            commodityNum: cnum,
            userName: userName,
        },
        success: function(data) {

        }
    });
    /* totl(); */
}
/* 加数量 */
function add(cid, sum) {
    let num = $("#commodityNum" + cid).val();
    //console.log(num);
    num++;
    $("#commodityNum" + cid).val(num);
    var price = $("#commodityPrice" + cid).text();
    sum = parseFloat(price * num);
    //console.log(num);
    function math() {
        sum = Math.round(sum * 100) / 100;
    }
    math();
    $("#commoditySum" + cid).text(sum);
    var id = cid;
    let cname = $("#commodityName" + cid).text();
    let cnum = $("#commodityNum" + cid).val();
    //console.log(cname);
    //console.log(cnum);
    $.ajax({
        url: "updateCar.do",
        type: "POST",
        dataType: "json",
        data: {
            commodityId: id,
            commodityName: cname,
            commodityNum: cnum,
            userName: userName,
        },
        success: function(data) {

        }
    });
}

/* 删除 */
function del(cid) {
    /*console.log(cid);*/
    let num = $("#commodityNum" + cid).val();
    //console.log(num);
    $.ajax({
        url: "deleteCar.do",
        type: "POST",
        dataType: "json",
        data: {
            commodityId: cid,
            commodityNum: num,
            userName: userName,
        },
        success: function(data) {
             alert("删除成功");
            $("#good" + cid).remove();
        }
    });
}
/*检查复选框*/
function checkboxOnclick(cid) {
    let sum = 0;
    if ($("#check" + cid).val() == 0) {
        sum += parseFloat($("#commoditySum" + cid).text());
        let money = $("#money").text(); //取
        let moneys = parseFloat(money);
        moneys += sum; //算
        $("#money").text(moneys); //放
        $("#check" + cid).val(1);
    } else {
        var money = $("#money").text(); //取
        var moneys = parseFloat(money);
        sum = $("#commoditySum" + cid).text();
        var sums = parseFloat(sum);
        /* var smoney = moneys - sums; */
        moneys -= sums;
        moneys = Math.round(moneys * 100) / 100;
        //console.log(moneys);
        $("#money").text(moneys);
        $("#check" + cid).val(0);
        //console.log($("#check" + cid).val());
    }
}

/* 被选中的放入订单 */
/*function checkSome() {
    var len = $("input:checkbox:checked").length;
    console.log(len);
    var cid = $("#commodityId" + cid).val();
    for (var i = 0; i <= len; i++) {
        if ($("#check" + i).val() == 0) {
            continue;
        }
        /!*var orders = new Array(2);*!/
        for (var i = 0; i < len; i++) {
            let j=i+1;
            //let oid = i+1;
            //var cid = $("#commodityId" + j).val();
            //var cnum = $("#commodityNum" + j).val();
            //console.log(oid);
            console.log(userName);
            console.log(cid);
            console.log(cnum);

        }
    }
    $.ajax({
        url: "orderServlet",
        type: "POST",
        dataType: "json",
        data: {
            //orderId: oid,
            commodityId: cid,
            userName: userName,
            commodityNum: cnum,
        },
        success: function(data) {
            //alert("已结算");
            //window.location.href = "userOrder";
        }
    });

}*/

function apply(cid){
    let cnum = $("#commodityNum" + cid).val();
    $.ajax({
        url: "orderServlet",
        type: "POST",
        dataType: "json",
        data: {
            //orderId: oid,
            commodityId: cid,
            userName: userName,
            commodityNum: cnum,
        },
        success: function(data) {
            alert("已结算");
            window.location.href = "userOrder";
        }
    });
}

window.onload = function() {
    let sum = 0;
    /* 返回值给购物车 */
    $.ajax({
        /* 获取全部数据 */
        url: "getCar.do",
        type: "GET",
        dataType: "json",
        data: {
             userName: userName,
        },
        success: function(result) {
            /* 读取成功时将数据读取,显示在页面内 */
            //console.log(result);
            var data = result.commodity;
            console.log(data);
            var length = data.length;
            //console.log(data.length);
            /*let commodityName = $("#commodityName").text();*/
            let car = $("#car");
            /* 获取购物车列表 */
            let k = 0;
            for (k = 0; k < length; k++) {
                var cid = data[k].commodityId;
                let cname =data[k].commodityName;
                let cinformation = data[k].commodityInformation;
                let cprice = data[k].commodityPrice;
                var cnum = data[k].commodityNum;
                /* 初始总价 */
                sum = parseFloat(cprice * cnum);
                //console.log(sum);
                //console.log(typeof sum);
                car.append(
                    `<div class="carts-goods" id="good` + cid + `">
					<input class="input" type="hidden" name="commodityId" id="commodityId` + cid + `" value="` + cid + `"> 
					<div class="cell c-select">
						<div class="c-checkbox">
							<input type="checkbox" name="check" class="each" value="0" id="check` + cid +
                    `" onclick="checkboxOnclick(` + cid + `)">
						</div>
					</div>
					<div class="cell c-goodsname" id ="commodityName` + cid + `">` + cname + `</div>
					<div class="cell c-props" id ="commodityInformation` + cid + `">` + cinformation + `</div>
					<div class="cell c-price">
						<span>￥</span>
						<div class="c-pricenum" id ="commodityPrice` + cid + `">` + cprice + `</div>
					</div>
					<div class="cell c-quantity">
						<button type="button" class="reduce" id="reduce` + cid + `" onclick="reduce(` + cid + `)">-</button>
						<input type="text" id ="commodityNum` + cid + `" value="` + cnum + `" class="text-num">
						<button type="button" class="add" id="add` + cid + `" onclick="add(` + cid + `)">+</button>
					</div>
					<div class="cell c-sum">
						<span>￥</span>
						<div class="c-sumnum" id ="commoditySum` + cid + `">` + sum + `</div>
					</div>
					<div class="cell c-action">
						<a href="#" id="remove" class="remove" onclick="del(` + cid + `)">移除商品</a>
					</div>
					<div class="cell c-action">
					<a href="#" id="apply" class="apply" onclick="apply(` + cid + `)">结算</a>
					</div>
					<input id="length" type="hidden" value="` + length + `">
					
				</div>`
                );
            }

            /* 全选 */
            $("#all").click(function(checkbox) {
                all = $(this).prop("checked")
                $(".each").each(function() {
                    $(this).prop("checked", all);
                })
                changeAll();
            });

            /*全选*/
            function changeAll() {
                let sum = 0;
                let length = $("#length").val();
                console.log(length);
                /* val=1表示被选中,val=0表示未被选 */
                if ($("#all").val() == 0) {
                    for (let i = 1; i <= length; i++) {
                        sum += parseFloat($("#commoditySum" + i).text());
                        console.log($("#commoditySum" + i).text());

                    }
                    $("#money").text(sum);
                    /* 所有选框都val为1 */
                    console.log(sum);
                    console.log(typeof sum);
                    $("input[type='checkbox']").val(1);
                    //console.log($("#all").val());
                    //$("#all").val(1);
                } else {
                    /* 反选 即在被选中时（val=1时）再次点击，值变为0*/
                    $("#money").text(0);
                    $("input[type='checkbox']").val(0);
                    /* $("#all").val(0); */
                }
            }
        }
    });
/*    /!* 全选 *!/
    $("#all").click(function(checkbox) {
        all = $(this).prop("checked")
        $(".each").each(function() {
            $(this).prop("checked", all);
        })
        changeAll();
    });*/
}
