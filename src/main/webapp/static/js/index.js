/* @description: 前台首页验证
   @author LL
   @date 2022/11/12 17:36
   @version 1.0
*/
/* 搜索按钮点击事件 跳转到分类页*/
checkSearch = function () {
    /* Sid为查询的内容 */
    let url ="result?Sid=" + $("#find").val();
    window.location.href = url;
}

window.onload = function() {
    $.ajax({
        /* 获取数据 */
        url: "index.do", //获取商品列表
        type: "GET",
        dataType: "json",
        success: function(data) {
            let products = $("#products");
            //console.log(data);
            var list = data.commodity; //商品列表
            //console.log(list);
            for (let i = 0; i < Math.ceil(list.length / 4); i++) { //每四个商品一行
                products.append(`<div class="layui-row" id="list` + i + `"></div>`);
            }

            let k = 0;
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                let domRow = $("#list" + i);
                /* let id = list[k].commodityId; */
                for (let j = 0; j < 4; j++) {
                    if (k >= list.length)
                        break;
                    domRow.append(
                        `<div class="layui-col-md3" name="" id="` + list[k].commodityId + `">
							<div class="thumbnail">
								<img src="` +list[k].commodityPhoto+ `" alt="...">
								<div class="caption">
								<!--<a href="#" onclick="details()">-->
							<a href="details?id=` + list[k].commodityId +`">
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
