package com.dao;

import com.bean.Commodity;
import com.mysql.jdbc.Connection;

import java.util.List;

/** 商品数据访问层的接口
 * @author Qgs123
 * @date 2022/11/10 9:38
 **/
public interface CommodityDao {
    /** 商品模糊查询
     * @param commodityName 商品名
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/27 15:28
     **/
     List<Commodity> getFuzzyQueryCommodity(String commodityName);
    /** 根据commodityName获取商品信息
     * @param commodityName 商品的名字信息
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/26 9:14
     **/
    List<Commodity> getNameCommodity(String commodityName);
    /** 获取所有的库存列表信息
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/10 9:40
     **/
    List <Commodity> getCommodityList();
    /** 获取某个商品详细信息
     * @param id  商品的id信息
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/23 21:17
     **/
    List <Commodity> getOneCommodity(int id);
    /** 新增商品库存
     * @param c 连接数据库
     * @param commodityName 商品名
     * @param commodityPrice 商品价格
     * @param commodityStock 商品库存
     * @param commodityInformation 商品信息
     * @return boolean
     * @author Qgs123
     * @date 2022/11/10 9:41
     **/
    boolean addCommodity(Connection c,String commodityName,Double commodityPrice,int commodityStock,String commodityInformation);
    /** 更新商品库存信息
     * @param c 连接数据库
     * @param commodityId 商品的id
     * @param commodityName 商品名
     * @param commodityPrice 商品价格
     * @param commodityStock 商品库存
     * @param commodityInformation 商品信息
     * @return boolean
     * @author Qgs123
     * @date 2022/11/10 9:41
     **/
    boolean updateCommodity(Connection c,String commodityName,Double commodityPrice,int commodityStock,String commodityInformation,int commodityId);
    /** 删除特定库存记录
     * @param c 连接数据库
     * @param commodityId 商品id
     * @return boolean
     * @author Qgs123
     * @date 2022/11/10 9:41
     **/
    boolean deleteCommodity(Connection c,int commodityId);
    /** 根据id查询到商品信息
     * @param c 连接数据库
     * @param commodityId 商品的id
     * @return boolean
     * @author Qgs123
     * @date 2022/11/20 17:36
     **/
    boolean selectCommodity(Connection c,int commodityId);
    /** 根据id查询
     * @param id 商品的id信息
     * @return Commodity 返回对应id商品所有数据
     * @author Qgs123
     * @date 2022/11/12 10:26
     *
     **/
     Commodity getOne(int id);
     /** 根据id查询商品图片
      * @param id  商品的id信息
      * @return com.bean.Commodity 返回对应id商品图片数据
      * @author Qgs123
      * @date 2022/11/21 21:54
      **/
     Commodity getOnePhoto(int id);

}
