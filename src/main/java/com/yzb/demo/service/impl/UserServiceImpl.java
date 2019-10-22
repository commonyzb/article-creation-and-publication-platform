package com.yzb.demo.service.impl;

import com.yzb.demo.dao.UserDao;
import com.yzb.demo.entity.User;
import com.yzb.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public Integer addUser(User user) {

        return userDao.addUser(user);

    }

    @Override
    public boolean deleteUser(User user) {

        return userDao.deleteUser(user);

    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean isExit(String userName, String userPassword) {
        return userDao.isExit(userName,userPassword);
    }

    @Override
    public User queryUserByNameAndPassword(String userName, String userPassword) {
        return userDao.queryByNameAndPassword(userName,userPassword);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
