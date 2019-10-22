package com.yzb.demo.service;

import com.yzb.demo.entity.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    boolean isExit(String userName, String userPassword);

    User queryUserByNameAndPassword(String userName, String userPassword);

    List<User> getAllUser();
}
