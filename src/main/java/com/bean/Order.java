package com.bean;

import java.util.Date;
import java.util.List;

/**
 * 订单表的所有商品项
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/14 20:27
 **/
public class Order {
    private int id;
    //订单编号(随机产生)
    private String oid;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    //下单时间
    private Date ordertime;
    //获取购物车中的商品项
    private double total;
    //获取地址
    private String address;
    //收货人姓名
    private String name;
    //电话
    private String telephone;
    //显示谁的订单，如果表中有外键，一般设置为对象。
    private User user;
    private List<OrderItem> list;
    public Order() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", user=" + user +
                ", list=" + list +
                '}';
    }
}