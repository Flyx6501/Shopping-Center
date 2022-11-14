/* @description: 前台首页验证
   @author LL
   @date 2022/11/12 17:36
   @version 1.0
*/
/* 搜索按钮点击事件 跳转到分类页*/
function checkSearch(search){
    /* Sid为查询的内容 */
    window.location.href="result.html?Sid="+$("#find").val();
}
window.onload = function() {
    $.ajax({
        /* 获取数据 */
        url: "http://localhost:8080/Shopping_Center/index.do", //获取商品列表
        type: "GET",
        dataType: "json",
        success: function(data) {
            let products = $("#products");
            /*商品列表*/
            var list = data.commodity;
            console.log(list[1]);
            /*每四个商品一行*/
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                products.append(`<div class="layui-row" id="list` + i + `"></div>`);
            }

            let k = 0;
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                let domRow = $("#list" + i);
                for (let j = 0; j < 4; j++) {
                    domRow.append(
                        `<div class="layui-col-md3">
							<div class="thumbnail">
							<a href="">
								<img src="" alt="商品图片">
								<div class="caption">
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