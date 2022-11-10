package com.dao;

import com.mysql.jdbc.Connection;

/**
 * 用户 Dao
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/8 15:10
 **/
public interface UserDao {

    /**
     * 登陆时查看出入的用户和密码是否与数据库中的相匹配
     *
     * @param c        JDBC链接
     * @param userName 用户名
     * @param password 用户密码
     * @return boolean
     * @author l666888999
     * @date 2022/11/07 22:37
     **/
     boolean  getUserByUsernameAndPassword(Connection c, String userName, String password);

    /** 注册用户名和密码
         * @param c JDBC链接
         * @param userName 用户名
         * @param password 用户密码
         * @param email 用户邮箱
         * @param nickName 用户昵称
         * @return boolean
     * @author l666888999
     * @date 2022/11/10 16:44
     **/
    boolean insertUser(Connection c, String userName, String password, String email, String nickName);
    boolean findUserByUserName(Connection c,String userName);
}

