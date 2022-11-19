package com.bean;

/**
 * 用户实体类
 * @author l66888999
 * @version 1.0
 * @date 2022/11/07 18:37
 */
public class User {
    private int useId;
    private String userUsername;
    private String password;
    private String email;
    private String address;
    private String nickname;

    public User() {
    }

    public User( String userUsername, String userPassword, String email, String address, String nickname) {
       // this.useId = useId;
        this.userUsername = userUsername;
        this.password = userPassword;
        this.email = email;
        this.address = address;
        this.nickname = nickname;
    }

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "useId=" + useId +
                ", userUsername='" + userUsername + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
