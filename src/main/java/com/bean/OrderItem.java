package com.bean;

/**
 * 商品项
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/14 21:04
 **/
public class OrderItem {
    public OrderItem() {
    }
    private String itemid;
    private int buynum;

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    //外键
    private Commodity commodity;
    //外键
    private Order order;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}