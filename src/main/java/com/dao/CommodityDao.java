package com.dao;

import com.bean.Commodity;
import com.mysql.jdbc.Connection;

import java.util.List;

/** 商品数据访问层的接口
 * @author Qgs123
 * @date 2022/11/10 9:38
 **/
public interface CommodityDao {
    /** 获取所有的库存列表信息
     * @return java.util.List<com.bean.Commodity>
     * @author Qgs123
     * @date 2022/11/10 9:40
     **/
    List <Commodity> getCommodityList();
    /** 新增库存
     * @param commodity 商品表的信息
     * @return boolean
     * @author Qgs123
     * @date 2022/11/10 9:41
     **/
    boolean addCommodity(Commodity commodity);
    /** 修改库存
     * @param commodity 商品表的信息
     * @return boolean
     * @author Qgs123
     * @date 2022/11/10 9:41
     **/
    boolean updateCommodity(Commodity commodity);
    /** 删除特定库存记录
     * @param commodity 商品表的信息
     * @return boolean
     * @author Qgs123
     * @date 2022/11/10 9:41
     **/
    boolean delCommodity(String commodity);
    /** 根据id查询
     * @param id 商品的id信息
     * @return Commodity 返回对应id商品所有数据
     * @author Qgs123
     * @date 2022/11/12 10:26
     *
     **/
     Commodity getOne(int id);
}
