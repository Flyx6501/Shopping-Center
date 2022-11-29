package com.bean;

import com.utils.CommodityNotFindException;

import java.util.Map;

/**购物车操作
 * @author  Qgs123
 * @version 1.0
 * @date 2022/11/19 12:27
 **/
public class CarOperate extends Car{
    public CarOperate() {
    }

    public CarOperate(Map<String, Integer> car) {
        super(car);
    }

    /** 新增
     * @param commodityId  商品的id
     * @author Qgs123
     * @date 2022/11/19 15:14
     **/
    public void add(String commodityId){
        Map<String, Integer> car = super.getCar();
        Integer commodityCount = car.get(commodityId);
        car.put(commodityId,(commodityCount==null)?1:commodityCount+1);
        super.setCar(car);
    }

    public void add(String commodityId,int count){
        Map<String, Integer> car = super.getCar();
        Integer commodityCount = car.get(commodityId);
        car.put(commodityId,(commodityCount==null)?1:commodityCount+count);
        super.setCar(car);
    }
    /** 删除
     * @param commodityId 商品id
     * @author Qgs123
     * @date 2022/11/19 15:37
     **/
    public void remove(String commodityId) throws CommodityNotFindException {
        Map<String, Integer> car = super.getCar();
        Integer commodityCount = car.get(commodityId);
        for(String cId:car.keySet()){
            if(cId.equals(commodityId)){
                if(car.get(cId) == 1){
                    car.remove(cId);
                    super.setCar(car);
                }else {
                    car.put(cId,commodityCount-1);
                    super.setCar(car);
                }
            }else{
                throw new CommodityNotFindException("数据删除出错，请重试！");
            }
        }
    }
}