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
        url: "#",
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
    var num = $("#commodityNum" + cid).val();
    num++;
    $("#commodityNum" + cid).val(num);
    var price = $("#commodityPrice" + cid).text();
    sum = parseFloat(price * num);

    function math() {
        sum = Math.round(sum * 100) / 100;
    }
    math();
    $("#commoditySum" + cid).text(sum);
    var id = cid;
    let cname = $("#commodityName" + cid).text();
    let cnum = $("#commodityNum" + cid).val();
    /* console.log(cname);
    console.log(cnum); */
    $.ajax({
        url: "#",
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
    $("#good" + cid).remove();
    $.ajax({
        url: "#",
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
        /*console.log(moneys);*/
        $("#money").text(moneys);
        $("#check" + cid).val(0);
        /* console.log($("#check" + cid).val()); */
    }
}

/*全选*/
function changeAll() {
    let sum = 0;
    /* val=1表示被选中,val=0表示未被选 */
    if ($("#all").val() == 0) {
        for (let i = 1; i <= 2; i++) {
            sum += parseFloat($("#commoditySum" + i).text());
        }
        $("#money").text(sum);
        /* 所有选框都val为1 */
        /*console.log(sum);*/
        $("input[type='checkbox']").val(1);
        /*console.log($("#all").val());*/
        /* $("#all").val(1); */
    } else {
        /* 反选 即在被选中时（val=1时）再次点击，值变为0*/
        $("#money").text(0);
        $("input[type='checkbox']").val(0);
        /* $("#all").val(0); */
    }
}

/* 被选中的放入购物车 */
function checkSome() {
    for (var i = 0; i <= 2; i++) {
        if ($("#check" + i).val() == 0) {
            continue;
        }
        var orders = new Array(2);
        for (var i = 0; i < 2; i++) {
            let j=i+1;
            var order = {};
            order["oid"] = j;
            order["cid"] = $("#commodityId" + j).val();
            /* order["userName"] = userName; */
            order["cnum"] = $("#commodityNum" + j).val();

            orders[i] = order;
            var json = JSON.stringify(orders);
        }
        /*console.log(json);*/
    }

    $.ajax({
        url: "#",
        type: "post",
        dataType: "json",
        data: {
            json,
        },
        success: function(data) {

        }
    });

}

window.onload = function() {
    let sum = 0;
    /* 返回值给购物车 */
    $.ajax({
        /* 获取全部数据 */
        url: "#",
        type: "GET",
        dataType: "json",
        data: {
             userName: userName,
        },
        success: function(commodity) {
            /* 读取成功时将数据读取,显示在页面内 */
            let commodityName = $("#commodityName").val;
            let car = $("#car");
            /* 获取购物车列表 */
            let k = 0;
            for (k = 0; k < 2; k++) {
                let cid = commodity[k].commodityId;
                let cname = commodity[k].commodityName;
                let cinformation = commodity[k].commodityInformation;
                let cprice = commodity[k].commodityPrice;
                let cnum = commodity[k].commodityNum;
                let csum = commodity[k].commoditySum;
                /* 初始总价 */
                sum = parseFloat(cprice * cnum);
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
				</div>`
                );
            }
        }
    });
    /* 全选 */
    $("#all").click(function(checkbox) {
        all = $(this).prop("checked")
        $(".each").each(function() {
            $(this).prop("checked", all);
        })
        changeAll();
    });
}
