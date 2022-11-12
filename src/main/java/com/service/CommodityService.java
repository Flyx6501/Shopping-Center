package com.service;

import com.bean.Commodity;
import com.mysql.jdbc.Connection;

import java.util.List;

/**
 * @author 23130
 * @version 1.0
 * @date 2022/11/11 10:38
 **/
public interface CommodityService {
    List<Commodity> getCommodityList();

    /**查询单个
     */
    Commodity getOne (int id);


}