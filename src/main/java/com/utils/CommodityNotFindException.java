package com.utils;

/**购物车自定义错误类
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/19 15:40
 **/
public class CommodityNotFindException extends Exception{
    public CommodityNotFindException() {
        super();

    }
    public CommodityNotFindException(String message) {
        super(message);

    }
}