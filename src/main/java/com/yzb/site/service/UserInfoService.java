package com.yzb.site.service;

import com.yzb.site.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    Integer addUserInfo(UserInfo userInfo);

    Integer deleteUserInfo(UserInfo userInfo);

    Integer deleteById(Integer id);

    Integer deleteByUid(Integer uid);

    Integer updateUserInfo(UserInfo userInfo);

    Integer countUserInfo();

    UserInfo findById(Integer id);

    UserInfo findByUid(Integer uid);

    List<UserInfo> findAll();
}
