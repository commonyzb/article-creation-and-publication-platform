package com.yzb.site.dao;

import com.yzb.site.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInfoDao {

    String TABLE_NAME = "user_info";
    String TABLE_COLUMN = "id,userName,sex,age,email,uid";
    String ENTITY_FIELDS = "#{id},#{user_name},#{sex},#{age},#{email},#{uid}";
    /*
     * CRUD
     */

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO user_info(user_name,sex,age,email,uid) VALUES(#{userName},#{sex},#{age},#{email},#{uid});")
    int addUserInfo(UserInfo userInfo);

    @Delete("DELETE FROM user_info WHERE id=#{id};")
    int deleteUserInfo(UserInfo userInfo);

    @Delete("DELETE FROM user_info WHERE id=#{id};")
    int deleteById(int id);

    @Delete("DELETE FROM user_info WHERE uid=#{uid};")
    int deleteByUid(int uid);

    @Update("UPDATE user_info SET user_name=#{userName},sex=#{sex},age=#{age},email=#{email},uid=#{uid} WHERE id=#{id};")
    int updateUserInfo(UserInfo userInfo);

    @Select("SELECT COUNT(*) FROM user_info;")
    int countUserInfo();

    @Select("SELECT * FROM user_info WHERE id=#{id};")
    UserInfo findById(int id);

    @Select("SELECT * FROM user_info WHERE uid=#{uid};")
    UserInfo findByUid(int uid);

    @Select("SELECT * FROM user_info WHERE id=#{id};")
    UserInfo findUserInfo(UserInfo userInfo);

    @Select("SELECT * FROM user_info;")
    List<UserInfo> findAll();

}
