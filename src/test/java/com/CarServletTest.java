package com;

import com.bean.Car;
import com.service.CarDaoImpl;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**π∫ŒÔ≥µ≤‚ ‘¿‡
 * @author Qgs123
 * @version 1.0
 * @date 2022/12/1 21:13
 **/
public class CarServletTest {
    @Test
    public void GetCarByUserIdTest(){
        CarDaoImpl carDao=new CarDaoImpl();
//        List<Map> car=carDao.getCommodityById("2");
//        System.out.println(car);
    }
    @Test
    public void UpdateCommodityTest(){
        CarDaoImpl carDao=new CarDaoImpl();
        Integer car=carDao.updateCommodity(59,1,1,2);
        System.out.println(car);
    }
    @Test
    public void DeleteCommodity(){
        CarDaoImpl carDao=new CarDaoImpl();
        Integer car=carDao.deleteCommodity(1,1);
        System.out.println(car);
    }
    @Test
    public void GetUserIdByName(){
        CarDaoImpl carDao=new CarDaoImpl();
        Integer car=carDao.getUserIdByName("h");
        System.out.println(car);
    }
}