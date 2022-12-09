package com.dao;

import com.bean.Car;

import java.util.List;
import java.util.Map;

/**购物车 Dao
 * @author Qgs123
 * @version 1.0
 * @date 2022/12/1 14:34
 **/
public interface CarDao {
    /** 获取用户的购物车列
     * @param userName  用户名
     * @return java.util.List<java.util.Map>
     * @author Qgs123
     * @date 2022/12/04 11:14
     **/
    List<Map> getCarByUserName(String userName);
    /** Map
     * @param commodityId  商品id
     * @return java.util.Map
     * @author Qgs123
     * @date 2022/12/04 11:15
     **/
    Map getCommodityById(String commodityId);
    /** 更改购物车商品数量
     * @param carId 购物车Id
     * @param userId 用户id
     * @param commodityId 购物车id
     * @param count 数量
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/01 14:36
     **/
    Integer updateCommodity(Integer carId,Integer userId,Integer commodityId,Integer count);
    /** s删除购物车
     * @param userId  用户id
     * @param  commodityId 购物车id
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/01 14:37
     **/
    Integer deleteCommodity(Integer userId,Integer commodityId);
    /** 添加商品
     * @param userId 用户id
     * @param commodityId 商品id
     * @param count 数量
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/04 11:21
     **/
    Integer addCommodity(Integer userId,Integer commodityId,Integer count);
    /** 购物车用户名找id
     * @param userName 用户名
     * @return java.lang.Integer
     * @author Qgs123
     * @date 2022/12/09 15:11
     **/
    Integer getUserIdByName(String userName);
}