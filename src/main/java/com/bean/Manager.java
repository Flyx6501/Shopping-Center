package com.bean;

/**
 * @author l666888999
 * @version 1.0
 * @date 2022/11/8 15:05
 **/
public class Manager {
    private int manageId;
    private String userName;
    private String password;

    public Manager(int manageId, String userName, String password) {
        this.manageId = manageId;
        this.userName = userName;
        this.password = password;
    }
    public Manager(){

    }

    public int getManageId() {
        return manageId;
    }

    public void setManageId(int manageId) {
        this.manageId = manageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/**  得到管理员ID,姓名、密码
     * @return java.lang.String
 * @author l666888999
 * @date 2022/11/08 18:10
 **/
    @Override
    public String toString() {
        return "Manager{" +
                "manageId=" + manageId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}