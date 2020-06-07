package com.yzb.site.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.User;
import com.yzb.site.service.UserInfoService;
import com.yzb.site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/userListPage")
    public ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage/user-list");
        return modelAndView;
    }

    @RequestMapping("/user/list")
    public ResultResponse getUserList(@RequestParam(name = "page") int currentPage,@RequestParam(name = "limit") int pageSize,@RequestParam(name = "userName",required = false) String userName){
        List<User> userList = null;
        PageInfo<User> userPageInfo = null;
        ResultResponse resultResponse = null;
        if(userName == null){
            PageHelper.startPage(currentPage,pageSize);
            userList = userService.findAllUsers();
        }
        else {
            userList = new ArrayList<>(1);
            User user = userService.findByName(userName);
            if(user != null){
                userList.add(userService.findByName(userName));
            }
        }
        if(userList.isEmpty() == false){
            userPageInfo = new PageInfo<>(userList);
            resultResponse = new ResultResponse(0,"查询成功！");
        }
        else {
            userPageInfo = new PageInfo<>();
            resultResponse = new ResultResponse<>(1,"用户"+userName+"不存在！！！");
        }
        resultResponse.setData(userPageInfo);
        return resultResponse;
    }

    @PostMapping("/user/updateUserStatus")
    public ResultResponse updateUserStatus(User user){
        ResultResponse resultResponse = new ResultResponse(200,"");
        Integer status = userService.updateUserStatus(user);
        if(status == 1){
            resultResponse.setMessage("更新状态成功！");
        }
        else {
            resultResponse.setMessage("更新状态失败！");
        }
        return resultResponse;
    }

    @PostMapping("/user/deleteById")
    public ResultResponse deleteUserById(Integer uid){
        ResultResponse resultResponse = null;
        if(userService.deleteById(uid) == 1 && userInfoService.deleteByUid(uid) == 1){
            resultResponse = new ResultResponse(200,"删除用户成功！");
            return resultResponse;
        }
        else {
            resultResponse = new ResultResponse(0,"删除用户失败！");
            return resultResponse;
        }
    }

}
