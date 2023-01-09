package com.bean;

import java.util.Arrays;
/** 商品实体类
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/10 10:00
 **/
public class Commodity {
    private int commodityId;
    private String commodityName;
    private Double commodityPrice;
    private int commodityStock;
    private String  commodityPhoto;
    private String commodityInformation;
    private String commodityComment;

    private int commodityNum;
    public Commodity(){
    }
    public Commodity(int commodityId, String commodityName, Double commodityPrice, int commodityStock, String commodityPhoto, String commodityInformation, String commodityComment ,int commodityNum) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.commodityStock = commodityStock;
        this.commodityPhoto = commodityPhoto;
        this.commodityInformation = commodityInformation;
        this.commodityComment = commodityComment;
        this.commodityNum = commodityNum;
    }

    public  int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public int getCommodityStock() {
        return commodityStock;
    }

    public void setCommodityStock(int commodityStock) {
        this.commodityStock = commodityStock;
    }

    public String getCommodityPhoto() {
        return commodityPhoto;
    }

    public void setCommodityPhoto(String commodityPhoto) {
        this.commodityPhoto = commodityPhoto;
    }

    public String getCommodityInformation() {
        return commodityInformation;
    }

    public void setCommodityInformation(String commodityInformation) {
        this.commodityInformation = commodityInformation;
    }

    public String getCommodityComment() {
        return commodityComment;
    }

    public void setCommodityComment(String commodityComment) {
        this.commodityComment = commodityComment;
    }

    public int getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(int commodityNum) {
        this.commodityNum = commodityNum;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", commodityStock=" + commodityStock +
                ", commodityPhoto=" + commodityPhoto +
                ", commodityInformation='" + commodityInformation + '\'' +
                ", commodityComment='" + commodityComment + '\'' +
                ", commodityNum='" + commodityNum +
                '}';
    }
}
