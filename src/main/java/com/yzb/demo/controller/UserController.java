package com.yzb.demo.controller;

import com.yzb.demo.entity.User;
import com.yzb.demo.service.UserService;
import com.yzb.demo.utils.MD5Util;
import com.yzb.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView loginPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("signin");
        return modelAndView;
    }

    @PostMapping("/user")
    public User addUser(@RequestParam(name="userName")String userName, @RequestParam(name="userPassword")String userPassword){
        User user=new User();
        user.setUserName(userName);
        String salt= StringUtils.createStringRandom(8);
        user.setUserPassword(MD5Util.md5(userPassword+salt));
        user.setSalt(salt);
        user.setStatus(1);
        userService.addUser(user);
//        System.out.println("新创建用户id为："+user.getUid());
        return user;
    }

    @RequestMapping("/user/allUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
