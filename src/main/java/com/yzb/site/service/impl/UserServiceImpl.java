package com.yzb.site.service.impl;

import com.yzb.site.dao.UserDao;
import com.yzb.site.entity.User;
import com.yzb.site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updateUserStatus(User user) {
        return userDao.updateUserStatus(user);
    }

    @Override
    public int validUserName(String userName) {
        return userDao.validUserName(userName);
    }

    @Override
    public int countUser() {
        return userDao.countUser();
    }

//    @Override
//    public User validUser(String userName, String userPassword) {
//        return userDao.validUser(userName,userPassword);
//    }

    @Override
    public User validUser(User user) {
        return userDao.validUser(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findByName(String userName) {
        return userDao.findUserByName(userName);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}
