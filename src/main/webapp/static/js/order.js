/* @description: TODO
   @author 小花妹妹
   @date 2022/11/13 21:42
   @version 1.0
*/
layui.use(['table', 'laypage', 'layer'], function() {
    //获取当前id为baseUrl的值
    var baseUrl = $("#baseUrl").val()
    var table = layui.table,
        laypage = layui.laypage,
        layer = layui.layer;
        //加载table实例
        table.render({
            // elem属性用来绑定容器的id属性值
            elem: '#demo',
            id: 'order_table',
            height: 500,
            // toolbar: '#toolbarDemo',
            //url接口地址。
            //默认会自动传递两个参数：?page=1&limit=30(该参数可通过request自定义)，page代表当前页码、limit代表每页数据量
            url: '#', //TODO
            //开启分页
            page: true,
            cols: [[
                {type: 'checkbox', unresize: true},
                {field: 'order_id', title: 'ID', width: 100, unresize: true},
                {field: 'username', title: '用户名', width: 200, unresize: true},
                {field: 'com_name', title: '商品名称', width: 230, unresize: true},
                {field: 'com_num', title: '商品数量', width: 250, unresize: true},
                {field: 'com_price', title: '价格', width: 230, unresize: true},
                // {field: 'operate',title: '操作',width: 200, toolbar: '#barDemo', width:150},
            ]],
        });
    });

    $('#customer-search-btn').on('click', function () {
        var keyWord = $('#keyword').val(); //得到搜索框里已输入的数据
        // console.log(keyWord, 8888)
        //执行重载
        table.reload('customer_table', {
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                userName: keyWord //在表格中进行搜索
            }
        });
    })





