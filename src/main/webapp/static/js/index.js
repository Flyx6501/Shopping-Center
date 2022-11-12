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