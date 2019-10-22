package com.yzb.demo.entity;

import com.yzb.demo.utils.StringUtils;

public class User {
    private Integer uid;
    private String userName;
    private String userPassword;
    private Integer status = 1;
    private String salt;

    public User() {
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, Integer status) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.status = status;
    }

    public User(Integer uid, String userName, String userPassword, Integer status) {
        this.uid = uid;
        this.userName = userName;
        this.userPassword = userPassword;
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(){
        this.salt=StringUtils.createStringRandom(10);
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", status=" + status +
                '}';
    }
}
