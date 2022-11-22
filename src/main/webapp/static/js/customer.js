/* @description: TODO
   @author 小花妹妹
   @date 2022/11/13 21:42
   @version 1.0
*/
layui.use(['table', 'laypage', 'layer'], function() {
    var baseUrl = $("#baseUrl").val()
    var table = layui.table,
        laypage = layui.laypage,
        layer = layui.layer;

    //加载table实例
    table.render({
        // elem属性用来绑定容器的id属性值
        elem: '#demo',
        height: 500,
        //工具栏
        toolbar: '#toolbarDemo',
        //url接口地址。
        //默认会自动传递两个参数：?page=1&limit=30(该参数可通过request自定义)，page代表当前页码、limit代表每页数据量
        url: '${APP_PATH}/index.do',
        //开启分页
        page: true,
        cols: [[
            {type: 'checkbox', unresize: true},
            {field: 'id',title: 'ID',width: 100, unresize: true},
            {field: 'username',title: '用户名',width: 150, unresize: true},
            {field: 'email',title: '电子邮箱',width: 220, unresize: true},
            {field: 'city',title: '收货地址',width: 250, unresize: true},
            {field: 'nickname',title: '昵称',width: 260, unresize: true},
            {field: 'operate',title: '操作',width: 200,toolbar: '#barDemo', unresize: true}
        ]],

    });

    $('#customer-search-btn').on('click', function () {
        var keyWord = $('#keyword').val(); //得到搜索框里已输入的数据
        console.log(keyWord, 8888)
        //执行重载
        table.reload('commodity_table', {
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                com_name: keyWord //在表格中进行搜索
            }
        });
    })

    //操作列的按钮绑定各自的操作
    table.on('tool(test)', function(obj) {
        console.log(obj);
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值

        if (layEvent == 'edit') {
            layer.open({
                type: 2,
                title: '编辑用户信息',
                area: ['50%', '80%'],
                offset: '40px',
                content: baseUrl+"/customerModify",
                success: function(layer0, index) {
                    //少了这个是不能从父页面向子页面传值的
                    var body = layer.getChildFrame('body', index);
                    //获取子页面的元素，进行数据渲染
                    body.contents().find("#id").val(data.id);
                    body.contents().find('#username').val(data.username);
                    body.contents().find('#email').val(data.email);
                    body.contents().find('#city').val(data.city);
                    body.contents().find('#nickname').val(data.nickname);
                }
            });
        } else if (layEvent == 'del') {
            layer.confirm('确定删除吗?', {
                icon: 3,
                title: '提示'
            }, function(index) {
                var loadIndex = layer.load();
                $.ajax({
                    url: "/user/del?id=" + data.id, //后台接口
                    type: "get",
                    success: function(res) {
                        layer.close(loadIndex);
                        if (res.data == 200) {
                            layer.msg("删除成功！");
                            window.location.reload();
                        } else {
                            layer.msg("删除失败！");
                        }
                    },
                    error: function(response) {
                        layer.close(loadIndex);
                        layer.msg("请求出错，请重试！");
                    }
                });
                layer.close(index);
            });
        }
    });

    $('#add').on('click', function() {
        layer.open({
            type: 2,
            title: '新增用户信息',
            area: ['50%', '80%'],
            offset: '40px',
            content: baseUrl+"/customerAdd"
        });
    });
});
