/* @description: 商品分类列表展示
   @author LL
   @date 2023/01/14 10:08
   @version 1.0
*/
var url = window.location.search;
var sname = url.split("=");
var name = decodeURI(sname[1]);
//console.log(sname[1]);
//console.log(name);
window.onload = function() {
    $("#sortName").text(name);
    let commodityName = $("#sortName").text();
    //console.log(commodityName);
    $.ajax({
        /* 获取数据 */
        url: "getFuzzyQuery.do",
        type: "GET",
        dataType: "json",
        data:{
            commodityName:commodityName,
        },
        success: function(data) {
            let products = $("#products");
            var list = data.commodity;
            //onsole.log(list);
            /*遍历显示*/
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                products.append(`<div class="layui-row" id="list` + i + `"></div>`);
            }
            let k = 0;
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                let domRow = $("#list" + i);
                for (let j = 0; j < 4; j++) {
                    domRow.append(
                        `<div class="layui-col-md3" name="" id="` + list[k].commodityId + `">
							<div class="thumbnail">
								<img src="` +list[k].commodityPhoto+ `" alt="...">
								<div class="caption">
							<a href="beforedetails?id=` + list[k].commodityId +`">
									<h3>` + list[k].commodityName + `</h3>
										<p>` + list[k].commodityPrice + `</p>
									</a>
								</div>
							</div>
						</div>`
                    );
                    k += 1;
                }
            }
        }
    });
}
