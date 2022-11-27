package com;

import com.bean.Commodity;
import com.service.CommodityDaoImpl;
import com.service.CommodityServiceImpl;
import java.sql.Connection;
import com.utils.JDBCUtil;
import org.junit.Test;
import java.util.List;

/**商品列表
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/12 19:55
 **/
public class CommodityServiceTest {
     /** 查询商品列表
      * @author Qgs123
      * @date 2022/11/20 16:51
      **/
    @Test
    public void getCommodityListTest() {
        CommodityServiceImpl commodityDao = new CommodityServiceImpl();

        List<Commodity> list = commodityDao.getCommodityList();
        System.out.println(list);
    }
     /** 获取某个商品的详情
     * @author Qgs123
     * @date 2022/11/20 16:53
      **/
    @Test
    public void getOne() {
        CommodityServiceImpl commodityDao = new CommodityServiceImpl();
        Commodity list1=commodityDao.getOne(4);
        System.out.println(list1);
    }
    /** 获取某个商品图片
     * @author Qgs123
     * @date 2022/11/22 11:38
     **/
    @Test
    public void getOnePhoto(){
        CommodityDaoImpl commodityDao=new CommodityDaoImpl();
        Commodity list=commodityDao.getOnePhoto(1);
        System.out.println(list);
    }
    /** 获取某个商品的详情信息
     * @author Qgs123
     * @date 2022/11/23 21:23
     **/
    @Test
    public void getOneCommodity(){
        CommodityDaoImpl commodityDao=new CommodityDaoImpl();
        List<Commodity>  list=commodityDao.getOneCommodity(1);
        System.out.println(list);
    }
    /** 根基商品名获取商品详情测试
     * @author Qgs123
     * @date 2022/11/26 9:52
     **/
    @Test
    public void GetNameCommodity(){
        CommodityDaoImpl commodityDao=new CommodityDaoImpl();
        List<Commodity> list=commodityDao.getNameCommodity("c");
        System.out.println(list);
    }
    /** 商品模糊查询
     * @author Qgs123
     * @date 2022/11/27 20:33
     **/
    @Test
    public void getFuzzyQueryCommodity(){
        CommodityDaoImpl commodityDao=new CommodityDaoImpl();
        List<Commodity> list=commodityDao.getFuzzyQueryCommodity("aa");
        System.out.println(list);
    }
}