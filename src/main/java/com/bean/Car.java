package com.bean;

/**购物车实体类
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/11 15:30
 **/
public class Car {
    private Commodity commodity;
    private int carCommodityCount;
    private double carCommodityTotal;
    public Car(){
    }
    public Car(Commodity commodity, int carCommodityCount, double carCommodityTotal) {
        this.commodity = commodity;
        this.carCommodityCount = carCommodityCount;
        this.carCommodityTotal = carCommodityTotal;
    }
    @Override
    public String toString() {
        return "Car{" +
                "commodity=" + commodity +
                ", carCommodityCount=" + carCommodityCount +
                ", carCommodityTotal=" + carCommodityTotal +
                '}';
    }
    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public double getCarCommodityTotal() {
        return carCommodityTotal;
    }

    public void setCarCommodityTotal(double carCommodityTotal) {
        this.carCommodityTotal = carCommodityTotal;
    }

    public int getCarCommodityCount() {
        return carCommodityCount;
    }

    public void setCarCommodityCount(int carCommodityCount) {
        this.carCommodityCount = carCommodityCount;
    }
}