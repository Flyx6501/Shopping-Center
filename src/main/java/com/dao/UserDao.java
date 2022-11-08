package com.dao;

import com.mysql.jdbc.Connection;

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/11/8 15:10
 **/
public interface UserDao {

    /** 登陆时查看出入的用户和密码是否与数据库中的相匹配
     * @param c JDBC链接
     * @param userId 用户的ID
     * @param password 用户密码
     * @return boolean
     * @author l666888999
     * @date 2022/11/07 22:37
     **/
    boolean searchName(Connection c, int userId, String password);


    /** 注册用户id和密码
     * @param c JDBC 连接
     * @param userId 用户ID
     * @param password 用户密码
     * @return boolean
     * @author l666888999
     * @date 2022/11/08 17:31
     **/
    boolean registerName(Connection c, int userId, String password);

}

