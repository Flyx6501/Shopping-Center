package com.dao;

import com.mysql.jdbc.Connection;

/** 管理员 Dao
 * @author l666888999
 * @version 1.0
 * @date 2022/11/8 15:10
 **/
public interface ManagerDao {

    /**  进行管理员登陆
     * @param c 链接数据库
     * @param manageName  管理员的name
     * @param password  管理员的密码
     * @return boolean
     * @author l666888999
     * @date 2022/11/8 15:26
     **/
    boolean searchName(Connection c,String manageName,String password);

    /** 进行管理员注册
     * @param c  进行数据库链接
     * @param manageId  管理员的ID
     * @param password  管理员的密码
     * @param userName  管理员的用户名
     * @return boolean
     * @author l666888999
     * @date 2022/11/8 15:37
     **/
    boolean registerName(Connection c, int manageId, String password, String userName);
}