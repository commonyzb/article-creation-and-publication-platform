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
    Integer addUserInfo(UserInfo userInfo);

    @Delete("DELETE FROM user_info WHERE id=#{id};")
    Integer deleteUserInfo(UserInfo userInfo);

    @Delete("DELETE FROM user_info WHERE id=#{id};")
    Integer deleteById(Integer id);

    @Delete("DELETE FROM user_info WHERE uid=#{uid};")
    Integer deleteByUid(Integer uid);

    @Update("UPDATE user_info SET user_name=#{userName},sex=#{sex},age=#{age},email=#{email},uid=#{uid} WHERE id=#{id};")
    Integer updateUserInfo(UserInfo userInfo);

    @Select("SELECT COUNT(*) FROM user_info;")
    Integer countUserInfo();

    @Select("SELECT * FROM user_info WHERE id=#{id};")
    UserInfo findById(Integer id);

    @Select("SELECT * FROM user_info WHERE uid=#{uid};")
    UserInfo findByUid(Integer uid);

    @Select("SELECT * FROM user_info WHERE id=#{id};")
    UserInfo findUserInfo(UserInfo userInfo);

    @Select("SELECT * FROM user_info;")
    List<UserInfo> findAll();


}
