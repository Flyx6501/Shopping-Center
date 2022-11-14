/* @description: TODO
   @author 小花妹妹
   @date 2022/11/13 21:42
   @version 1.0
*/
layui.use(['table', 'laypage', 'layer'], function() {
    var table = layui.table,
        laypage = layui.laypage,
        layer = layui.layer;

    //操作列的三个按钮绑定各自的操作
    table.on('tool(test)', function (obj) {
        console.log(obj);
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值


        if (layEvent == 'search') {
            var keyWord = $('#keyword').val(); //得到搜索框里已输入的数据
            //执行重载
            table.reload('test', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    keyword: keyWord //在表格中进行搜索
                }
            });
        }
    });
})


