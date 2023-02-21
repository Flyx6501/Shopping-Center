/* @description: 搜索结果
   @author LL
   @date 2023/01/14 21:09
   @version 1.0
*/
/* 获取搜索参数 */
var url = window.location.search;
var findName = url.split("=");
var searchName = decodeURI(findName[1]);
//console.log(findName[1]);
//console.log(searchName);

window.onload = function() {
    $.ajax({
        /* 获取数据 */
        url: "getFuzzyQuery.do",
        type: "GET",
        dataType: "json",
        data: {
            commodityName: searchName,
        },
        success: function(data) {
            let goodlist = $("#goodlist");
            var list = data.commodity;
            //console.log(list);
            /*遍历显示*/
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                goodlist.append(`<div class="layui-row" id="list` + i + `"></div>`);
            }
            let k = 0;
            for (let i = 0; i < Math.ceil(list.length / 4); i++) {
                let domRow = $("#list" + i);
                for (let j = 0; j < 4; j++) {
                    if (k >= list.length)
                        break;
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
