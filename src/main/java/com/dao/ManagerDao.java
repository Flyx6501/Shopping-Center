package com.dao;

import com.bean.User;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.List;

/** 管理员 Dao
 * @author l666888999
 * @version 1.0
 * @date 2022/11/8 15:10
 **/
public interface ManagerDao {
    /**
     * 进行管理员登陆
     *
     * @param c          链接数据库
     * @param manageName 管理员的name
     * @param password   管理员的密码
     * @return boolean
     * @author l666888999
     * @date 2022/11/8 15:26
     **/
    boolean searchName(Connection c, String manageName, String password);

    /**
     * 进行管理员注册
     *
     * @param c        进行数据库链接
     * @param password 管理员的密码
     * @param userName 管理员的用户名
     * @return boolean
     * @author l666888999
     * @date 2022/11/8 15:37
     **/
    boolean registerName(Connection c, String password, String userName);

    /**
     * 更新用户信息
     *
     * @param c        数据库连接
     * @param userName 用户姓名
     * @param password 密码
     * @param email    邮件
     * @param nickName 昵称
     * @return boolean
     * @author l666888999
     * @date 2022/11/11 20:28
     **/
    boolean updateUserByUserId(Connection c, String userName, String password, String email, String nickName, String userNames);

    /** TODO
     * @param c 链接数据库
     * @param userName 用户名
     * @return java.util.List<com.bean.User>
     * @author l666888999
     * @date 2022/11/17 8:15
     **/
    //List<User> getUserByUserName(Connection c,String userName);

    /**
     * 增加用户信息
     *
     * @param c        进行数据库连接
     * @param userName 用户名
     * @param email    邮件
     * @param address  收货地址
     * @param nickName 昵称
     * @return boolean
     * @author l666888999
     * @date 2022/11/19 21:39
     **/
    boolean addUser(Connection c, String userName, String email, String address, String nickName);

    /**
     * 通过用户名查询用户
     *
     * @param c           链接数据库
     * @param userName    用户名
     * @param currentPage 当前页
     * @param pageSize    每页内容
     * @return java.util.List<com.bean.User>
     * @author l666888999
     * @date 2022/11/23 8:44
     **/
    List<User> getUserByUserName(Connection c, String userName, int currentPage, int pageSize);

    /**
     * 不分页查询用户
     *
     * @param c        数据库链接
     * @param userName 用户名
     * @return java.util.List<com.bean.User>
     * @author l666888999
     * @date 2022/11/23 8:45
     **/
    List<User> getUserByUserNames(Connection c, String userName);

    /**
     * 删除用户信息
     *
     * @param c  数据库链接
     * @param Id Id
     * @return boolean
     * @author l666888999
     * @date 2022/11/23 8:46
     **/
    boolean deleteUserById(Connection c, int Id) throws SQLException;

    /**
     * 更新用户信息
     *
     * @param c
     * @param userName
     * @param address
     * @param email
     * @param nickName
     * @param Id
     * @return boolean
     * @author l666888999
     * @date 2022/11/23 8:46
     **/
    boolean updateManagerById(Connection c, String userName, String address, String email, String nickName, int Id);

    /**
     * 查询所有用户信息
     *
     * @param c
     * @return java.util.List<com.bean.User>
     * @author l666888999
     * @date 2022/11/23 8:47
     **/
    List<User> selectUser(Connection c);

    /**
     * 查询用户数目
     *
     * @param c
     * @param userName
     * @return int
     * @author l666888999
     * @date 2022/11/26 22:00
     **/
    int getTotalNum(Connection c, String userName);
}