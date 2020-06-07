package com.yzb.site.service;

import com.yzb.site.entity.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    int deleteUser(User user);

    int deleteById(int id);

    int updateUser(User user);

    int updateUserStatus(User user);

    int validUserName(String userName);

//    User validUser(String userName, String userPassword);

    int countUser();

    User validUser(User user);

    User findById(int id);

    User findByName(String userName);

    List<User> findAllUsers();
}
