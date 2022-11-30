package com.bean;

import com.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**购物车实体类
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/11 15:30
 **/
public class Car {
    @Autowired
    private CommodityService commodityService;
    /**用户商品购物车，存放所有商品数据,用map存放商品(id和对应num)
    */
     private Map<String,Integer> car;
    private List<Commodity> commodityList;
    private Integer carCommodityCount;
    private Double carPriceCount;

    public Car(){
    }
    public Car(Map<String,Integer> car) {
        this.car = car;
        this.commodityList = new ArrayList<>();
        this.carPriceCount = Double.valueOf(0);
        for(String commodityId:car.keySet()){
            Commodity cc =commodityService.getOne(Integer.parseInt(commodityId));
            this.commodityList.add(cc);
        }
        for(Commodity commodity:commodityList){
            String commodityId = String.valueOf(commodity.getCommodityId());
            this.carCommodityCount += car.get(commodityId);
            this.carPriceCount += commodity.getCommodityPrice() * car.get(commodityId);

        }

    }
    @Override
    public String toString() {
        String commodityText = " ";
        if(this.car.size() == 0){
            return "Car{ +Your have not buy any thing" +
                    ", carCommodityCount= 0" +
                    '}';
        }
        for(Commodity commodity:this.commodityList){
            commodityText += commodity.getCommodityName() + ", ";
        }
        return "Car{" +
                "commodity=" + commodityText +
                ", carCommodityCount=" + this.carCommodityCount +
                '}';
    }
    public Map<String,Integer> getCar() {
        return this.car;
    }

    public List<Commodity> getCommodityies() {
        return this.commodityList;
    }

    public void setCar(Map<String,Integer> car) {
        this.car = car;
        this.commodityList = new ArrayList<>();
        this.carPriceCount = Double.valueOf(0);
        for (String commodityId : car.keySet()) {
            Commodity cc = commodityService.getOne(Integer.parseInt(commodityId));
            this.commodityList.add(cc);
        }
        for (Commodity commodity : commodityList) {
            String commodityId = String.valueOf(commodity.getCommodityId());
            this.carCommodityCount += car.get(commodityId);
            this.carPriceCount += commodity.getCommodityPrice() * car.get(commodityId);

        }
    }

    public Integer getCarCommodityCount(){
        return this.carCommodityCount;
    }

    public Double getCarPriceCount(){
        return this.carPriceCount;
    }
}