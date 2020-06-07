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
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfo(UserInfo userInfo) {
        return userInfoDao.deleteUserInfo(userInfo);
    }

    @Override
    public int deleteById(int id) {
        return userInfoDao.deleteById(id);
    }

    @Override
    public int deleteByUid(int uid) {
        return userInfoDao.deleteByUid(uid);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public int countUserInfo() {
        return userInfoDao.countUserInfo();
    }

    @Override
    public UserInfo findById(int id) {
        return userInfoDao.findById(id);
    }

    @Override
    public UserInfo findByUid(int uid) {
        return userInfoDao.findByUid(uid);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }
}
