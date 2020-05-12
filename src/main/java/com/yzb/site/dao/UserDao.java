package com.yzb.site.dao;

import com.yzb.site.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    /*
     * CRUD
     */
    static final String TABLE_NAME = "user";
    static final String TABLE_FIELDS = "user_name,user_password,status,salt";
    static final String TABLE_ALL_FIELDS = "uid,user_name,user_password,status,salt";
    static final String PRIMARY_KEY = "uid";
    static final String UPDATE_FIELDS = "user_name=#{userName},user_password=#{userPassword},status=#{status},salt=#{salt}";
    static final String VERIFY_MESSAGE = "user_name=#{userName} AND user_password=#{userPassword}";

    static final String USER_FIELDS = "#{userName},#{userPassword},#{status},#{salt}";
    static final String USER_ID = "#{uid}";

    @Insert({"INSERT INTO",TABLE_NAME, "(",TABLE_FIELDS,") VALUES (",USER_FIELDS,")"})
    @Options(useGeneratedKeys = true,keyProperty = "uid",keyColumn = "uid")
    Integer addUser(User user);

    @Delete({"DELETE FROM ",TABLE_NAME, "WHERE ",PRIMARY_KEY," = ",USER_ID})
    Integer deleteUser(User user);

    @Delete({"DELETE FROM ",TABLE_NAME, "WHERE ",PRIMARY_KEY," = ",USER_ID})
    Integer deleteById(Integer id);

    @Update({"UPDATE ",TABLE_NAME," SET ",UPDATE_FIELDS," WHERE ",PRIMARY_KEY," = ",USER_ID})
    Integer updateUser(User user);

    @Update("UPDATE user SET status=#{status} WHERE uid=#{uid}")
    Integer updateUserStatus(User user);

    @Select("SELECT COUNT(*) FROM user;")
    Integer countUser();

    @Select({"SELECT * FROM ",TABLE_NAME, " WHERE ",VERIFY_MESSAGE})
    User validUser(User user);

//    @Select({"SELECT * FROM ",TABLE_NAME, " WHERE ",VERIFY_MESSAGE})
//    User validUser(String userName, String userPassword);

    @Select("SELECT * FROM user WHERE user_name=#{userName}")
    Integer validUserName(String userName);

//    @Select({"SELECT * FROM ",TABLE_NAME," WHERE ",VERIFY_MESSAGE})
//    User queryByNameAndPassword(String userName, String userPassword);

    @Select({"SELECT * FROM ",TABLE_NAME," WHERE ",PRIMARY_KEY," = ",USER_ID})
    User findUserById(Integer uid);

    @Select("SELECT * FROM user WHERE user_name=#{userName};")
    User findUserByName(String userName);

    @Select({"SELECT * FROM ",TABLE_NAME})
    List<User> findAllUsers();

}
