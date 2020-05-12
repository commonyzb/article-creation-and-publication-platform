package com.yzb.site.service.impl;

import com.yzb.site.dao.UserInfoDao;
import com.yzb.site.entity.UserInfo;
import com.yzb.site.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Integer addUserInfo(UserInfo userInfo) {
        return userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public Integer deleteUserInfo(UserInfo userInfo) {
        return userInfoDao.deleteUserInfo(userInfo);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userInfoDao.deleteById(id);
    }

    @Override
    public Integer deleteByUid(Integer uid) {
        return userInfoDao.deleteByUid(uid);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public Integer countUserInfo() {
        return userInfoDao.countUserInfo();
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoDao.findById(id);
    }

    @Override
    public UserInfo findByUid(Integer uid) {
        return userInfoDao.findByUid(uid);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }
}
