package com.dao;

import com.mysql.jdbc.Connection;

/** 用户 Dao
 * @author l666888999
 * @version 1.0
 * @date 2022/11/8 15:10
 **/
public interface UserDao {

    /** 登陆时查看出入的用户和密码是否与数据库中的相匹配
     * @param c JDBC链接
     * @param password 用户密码
     * @return boolean
     * @author l666888999
     * @date 2022/11/07 22:37
     **/
    boolean searchName(Connection c, String userName, String password);


    /** 注册用户id和密码
     * @param c JDBC 连接
     * @param password 用户密码
     * @return boolean
     * @author l666888999
     * @date 2022/11/08 17:31
     **/
    boolean registerName(Connection c, String password, String email, String nickName, String userName);
}

