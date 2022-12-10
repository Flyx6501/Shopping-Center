package com.bean;

/**
 * 定义订单类的Bean
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/24 19:29
 **/
public class Orders {
    private int orderId;
   private int commodityId;
   private int commodityNumber;

    public Orders(int orderId, int commodityId, int commodityNum) {
        this.orderId = orderId;
        this.commodityId = commodityId;
        this.commodityNumber = commodityNum;
    }
    public Orders(){

    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int commodityNumber() {
        return commodityNumber;
    }

    public void commodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", commodityId=" + commodityId +
                ", commodityNum=" + commodityNumber +
                '}';
    }
}