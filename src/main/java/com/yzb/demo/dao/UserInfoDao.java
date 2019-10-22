package com.yzb.demo.dao;

import com.yzb.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInfoDao {
    /*
     * CRUD
     */

    boolean addUserInfo(UserInfo userInfo);

    boolean deleteUserInfo(UserInfo userInfo);

    boolean updateUserInfo(UserInfo userInfo);

    UserInfo findById(Integer id);

    UserInfo findUserInfo(UserInfo userInfo);

    List<UserInfo> findAll();


}
