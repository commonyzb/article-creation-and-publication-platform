package com.yzb.site.vo;

import com.yzb.site.entity.User;

public class UserVO {

    private Integer userId;
    private String userName;
    private Integer status;

    public UserVO() {
    }

    public UserVO(User user){
        this.userId=user.getUid();
        this.userName=user.getUserName();
        this.status=user.getStatus();
    }

    public UserVO(Integer userId, String userName, Integer status) {
        this.userId = userId;
        this.userName = userName;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", status=" + status +
                '}';
    }
}
