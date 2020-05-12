package com.yzb.site.service;

import com.yzb.site.entity.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    Integer deleteUser(User user);

    Integer deleteById(Integer id);

    Integer updateUser(User user);

    Integer updateUserStatus(User user);

    Integer validUserName(String userName);

//    User validUser(String userName, String userPassword);

    Integer countUser();

    User validUser(User user);

    User findById(Integer id);

    User findByName(String userName);

    List<User> findAllUsers();
}
