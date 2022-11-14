package com.bean;

/**
 * 商品项
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/14 21:04
 **/
public class OrderItem {
    private String itemid;
    private int quantity;
    private double total;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemid='" + itemid + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}