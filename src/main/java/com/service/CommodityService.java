package com.service;

import com.bean.Commodity;
import java.util.List;
/**商品业务逻辑层接口
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/11 10:38
 **/
public interface CommodityService {
    /**查询商品表中的所有数据
    */
     List<Commodity> getCommodityList();
    /**查询单个商品详细信息
     */
    Commodity getOne (int id);
}