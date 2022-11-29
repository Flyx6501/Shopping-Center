/* @description: 搜索结果
   @author LL
   @date 2022/11/25 21:09
   @version 1.0
*/
/* 获取搜索参数 */
var url = window.location.search;
var findName = url.split("=");
/*console.log(findName[1]);*/

window.onload = function() {
    $.ajax({
        /* 获取数据 */
        url: "#",
        type: "GET",
        dataType: "json",
        data:{
          findName:findName,
        },
        success: function(data) {
            let goodlist = $("#good-list");
            var list = data;
            /*console.log(list);*/
            /*遍历显示*/
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                goodlist.append(`<div class="layui-row" id="list` + i + `"></div>`);
            }
            let k = 0;
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                let domRow = $("#list" + i);
                for (let j = 0; j < 4; j++) {
                    domRow.append(
                        `<div class="layui-col-md3">
							<div class="thumbnail">
								<img src="" alt="...">
								<div class="caption">
								<a href="">
								<img src="" alt="商品图片">
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