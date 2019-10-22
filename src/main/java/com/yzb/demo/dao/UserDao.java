package com.yzb.demo.dao;

import com.yzb.demo.entity.User;
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
 //   @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer addUser(User user);

    @Delete({"DELETE FROM ",TABLE_NAME, "WHERE ",PRIMARY_KEY," = ",USER_ID})
    boolean deleteUser(User user);

    @Update({"UPDATE ",TABLE_NAME," SET ",UPDATE_FIELDS," WHERE ",PRIMARY_KEY," = ",USER_ID})
    boolean updateUser(User user);

    @Select({"SELECT * FROM ",TABLE_NAME, " WHERE ",VERIFY_MESSAGE})
    boolean isExit(String userName, String userPassword);

    @Select({"SELECT * FROM ",TABLE_NAME," WHERE ",VERIFY_MESSAGE})
    User queryByNameAndPassword(String userName, String userPassword);

    @Select({"SELECT * FROM ",TABLE_NAME," WHERE ",PRIMARY_KEY," = ",USER_ID})
    User getUserById(int uid);

    @Select({"SELECT * FROM ",TABLE_NAME})
    List<User> getAllUsers();

}
