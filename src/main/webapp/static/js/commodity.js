/* @description: TODO
   @author 小花妹妹
   @date 2022/11/13 21:39
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
        elem: '#commodity',
        id: 'commodityTable',
        height: 500,
        // toolbar: '#toolbarDemo',
        //url接口地址。
        //默认会自动传递两个参数：?page=1&limit=30(该参数可通过request自定义)，page代表当前页码、limit代表每页数据量
        url: baseUrl + '/index.do',
        //开启分页
        page: true,
        cols: [[
            {type: 'checkbox', unresize: true},
            {field: 'commodityId',title: 'ID',width: 100, unresize: true},
            {field: 'commodityName',title: '商品名称',width: 150,unresize: true},
            {field: 'commodityPrice',title: '商品价格',width: 220,unresize: true},
            {field: 'commodityStock',title: '库存',width: 250,unresize: true},
            {field: 'commodityInformation',title: '商品描述',width: 260,unresize: true},
            {field: 'operate',title: '操作',width: 200, toolbar: '#barDemo', unresize: true},
        ]],
        parseData:function(d){
            //console.log(d)
            var newArr = []
            for (var i = 0; i < d.commodity.length; i++) {
                var item = (d.commodity)[i]
                // 往数组里面插入数据
                newArr.push({
                    commodityId: item.commodityId,
                    commodityName: item.commodityName,
                    commodityPrice: item.commodityPrice,
                    commodityStock: item.commodityStock,
                    commodityInformation: item.commodityInformation
                })
            }
            return{
                "code": d ? 0 : -1,
                "msg":'',
                "count":newArr.length, // 总条数
                "data": newArr
            }
        }
    });

    $('#commoditySearch').on('click', function () {
        var keyWord = $('#keyword').val(); //得到搜索框里已输入的数据
        // console.log(keyWord, 8888)
        //执行重载
        table.reload('commodityTable', {
            url:'#',
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                commodityName: keyWord //在表格中进行搜索
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
                title: '编辑商品信息',
                area: ['50%', '80%'],
                offset: '40px',
                content: baseUrl+"/commodityModify",
                success: function(layer0, index) {
                    //少了这个是不能从父页面向子页面传值的
                    var body = layer.getChildFrame('body', index);
                    //获取子页面的元素，进行数据渲染
                    body.contents().find("#commodityId").val(data.commodityId);
                    body.contents().find('#commodityName').val(data.commodityName);
                    body.contents().find('#commodityPrice').val(data.commodityPrice);
                    body.contents().find('#commodityStock').val(data.commodityStock);
                    body.contents().find('#commodityInformation').val(data.commodityInformation);
                },
                end: function () {
                    window.location.reload();
                }
            });
        } else if (layEvent == 'del') {
            layer.confirm('确定删除吗?', {
                icon: 3,
                title: '提示'
            }, function(index) {
                var loadIndex = layer.load();
                $.ajax({
                    url: baseUrl+'/deleteCommodity.do?commodityId=' + data.commodityId, //后台接口
                    // url: "/Shopping-Center/deleteCommodity.do?commodityId=" + data.commodityId,
                    type: "get",
                    dataType: 'json',
                    success: function(res) {
                        layer.close(index);
                        //console.log(res);
                        if (res.msg == 'success') {
                            //console.log(1111);
                            layer.msg("删除成功！", {
                                icon: 1,
                                time: 2000 //2秒关闭（如果不配置，默认是3秒）
                            }, function () {
                                //如果成功 关闭加载中这个进度条
                                layer.close(loadIndex);
                                // //刷新当前页面
                                window.location.reload();
                            });
                        } else {
                            //console.log(11112222);
                            layer.msg("删除失败！");
                        }
                    },
                    error: function(response) {
                        layer.close(loadIndex);
                        layer.msg("请求出错，请重试！");
                    }
                });

            });
        }
    });

    $('#add').on('click', function() {
        layer.open({
            type: 2,
            title: '新增商品信息',
            area: ['50%', '80%'],
            offset: '40px',
            content: baseUrl+"/commodityAdd",
            end: function () {
                window.location.reload();
            }
        });
    });
});