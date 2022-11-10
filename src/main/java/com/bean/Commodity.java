package com.bean;

import java.util.Arrays;

/** 商品实体类
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/10 9:37
 **/
public class Commodity {
    private int commodityId;
    private String commodityName;
    private int commodityPrice;
    private int commodityStock;
    private byte[] commodityPhoto;
    private String commodityInformation;
    private String commodityComment;
    public Commodity(){
    }
    public  Commodity(int commodityId,String commodityName,int commodityPrice,int commodityStock,byte[] commodityPhoto,String commodityInformation,String commodityComment){
        this.commodityId=commodityId;
        this.commodityName=commodityName;
        this.commodityPrice=commodityPrice;
        this.commodityStock=commodityStock;
        this.commodityPhoto=commodityPhoto;
        this.commodityInformation=commodityInformation;
        this.commodityComment=commodityComment;
    }

    public int getCommodityId() {
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

    public int getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(int commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public int getCommodityStock() {
        return commodityStock;
    }

    public void setCommodityStock(int commodityStock) {
        this.commodityStock = commodityStock;
    }

    public byte[] getCommodityPhoto() {
        return commodityPhoto;
    }

    public void setCommodityPhoto(byte[] commodityPhoto) {
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

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice='" + commodityPrice + '\'' +
                ", commodityStock=" + commodityStock +
                ", commodityPhoto=" + Arrays.toString(commodityPhoto) +
                ", commodityInformation='" + commodityInformation + '\'' +
                ", commodityComment='" + commodityComment + '\'' +
                '}';
    }
}