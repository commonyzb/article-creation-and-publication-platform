package com.yzb.site.service;

import com.yzb.site.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    int addUserInfo(UserInfo userInfo);

    int deleteUserInfo(UserInfo userInfo);

    int deleteById(int id);

    int deleteByUid(int uid);

    int updateUserInfo(UserInfo userInfo);

    int countUserInfo();

    UserInfo findById(int id);

    UserInfo findByUid(int uid);

    List<UserInfo> findAll();
}
