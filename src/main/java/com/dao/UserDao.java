package com.dao;

import com.mysql.jdbc.Connection;

public interface UserDao {
    void check(Connection c, int userId, String password);
/** 判断用户名是否已注册过
1.前端传变量：用户名username
2.根据username，查数据库中是否存在用户，其用户名为username
3.若存在，返回该用户对象 User
4.若不存在，返回null
SELECT * FROM xxx WHERE username = username;
* **/

    /** 校验用户名密码是否匹配
     * 1.前端传变量：用户名username，密码password
     * 2.根据传的username、password，查数据库中用户名密码是否匹配
     * 3.若匹配，返回该用户对象
     * 4.若不匹配，返回null
     * SELECT * FROM xxx WHERE username=username AND password=password;
     * **/

    void getUser(Connection c, int userId);
}

