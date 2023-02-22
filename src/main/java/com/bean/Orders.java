package com.bean;

import com.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** 订单类
 * @author Qgs123
 * @date 2023/02/21 22:01
 **/
public class Orders {
   @Autowired
    private CommodityService commodityService;
   private Map<String,Integer> orders;
   private Integer orderCommodityCount;
   private Double orderPriceCount;
   private List<Commodity> commodityList;

    public Orders() {
    }

    public CommodityService getCommodityService() {
        return commodityService;
    }

    public Integer getOrderCommodityCount() {
        return orderCommodityCount;
    }

    public Map<String, Integer> getOrders() {
        return orders;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public Double getOrderPriceCount() {
        return orderPriceCount;
    }

    public Orders(Map<String, Integer> order) {
        this.orders = orders;
        this.commodityList = new ArrayList<>();
        this.orderPriceCount = Double.valueOf(0);
        for(String commodityId:orders.keySet()){
            Commodity cc =commodityService.getOne(Integer.parseInt(commodityId));
            this.commodityList.add(cc);
        }
        for(Commodity commodity:commodityList){
            String commodityId = String.valueOf(commodity.getCommodityId());
            this.orderCommodityCount += orders.get(commodityId);
            this.orderPriceCount += commodity.getCommodityPrice() * orders.get(commodityId);

        }
    }
}