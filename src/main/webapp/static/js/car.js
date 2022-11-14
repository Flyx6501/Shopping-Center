/* @description: 购物车操作
   @author LL
   @date 2022/11/14 10:15
   @version 1.0
*/
$(function(){
    totl();
    goodsnum();
    // 全选
    $(".all").click(function() {
        all = $(this).prop("checked")
        $(".each").each(function() {
            $(this).prop("checked", all);
        })
    })
    // 减少商品数量
    $(".reduce").click(function(){
        var num = $(this).siblings(".text-num").val();
        if(num>0){
            num--;
            $(this).siblings(".text-num").val(num);
        };
        var price=$(this).parents().siblings(".c-price").children(".c-pricenum").text();
        var sum_num = $(this).parents().siblings(".c-sum").children(".c-sumnum");
        var sum = parseFloat(price*num);
        // console.log(sum);
        $(sum_num).text(sum);
        totl();
        goodsnum();
    });
    // 增加商品数量
    $(".add").click(function(){
        var num = $(this).siblings(".text-num").val();
        num++;
        $(this).siblings(".text-num").val(num);
        var price=$(this).parents().siblings(".c-price").children(".c-pricenum").text();
        var sum_num = $(this).parents().siblings(".c-sum").children(".c-sumnum");
        var sum = parseFloat(price*num);
        // console.log(sum);
        $(sum_num).text(sum);
        totl();
        goodsnum();
    });
    // 删除商品
    $(".remove").click(function(){
        $(this).parents(".carts-goods").remove();
        totl();
        goodsnum();
    });
    // 总价
    function totl(){
        let sumprice = 0;
        $.each($(".c-sumnum"),function() {
            sumprice+=parseFloat($(this).text());
            $(".show-money span").text(sumprice);
        });
    };
    // 统计商品数量
    function goodsnum(){
        let goods_num=0;
        $.each($(".text-num"),function() {
            goods_num+=parseInt($(this).val());
            $(".goods_num span").text(goods_num);
        });
    }

});