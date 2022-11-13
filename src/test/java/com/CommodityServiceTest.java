package com;

import com.bean.Commodity;
import com.mysql.jdbc.Connection;
import com.service.CommodityServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author 23130
 * @version 1.0
 * @date 2022/11/12 19:55
 **/
public class CommodityServiceTest {
    @Test
    public void getCommodityListTest() {
        CommodityServiceImpl commodityDao = new CommodityServiceImpl();

        List<Commodity> list = commodityDao.getCommodityList();
        System.out.println(list);

    }
}