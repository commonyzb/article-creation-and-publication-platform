package com.yzb.site.controller.user;

import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.User;
import com.yzb.site.entity.UserInfo;
import com.yzb.site.service.*;
import com.yzb.site.utils.MD5Util;
import com.yzb.site.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleCategoryService articleCategoryService;
    @Autowired
    private CommentService commentService;


    @GetMapping("/user/register")
    public ModelAndView userRegister(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/register");
        return modelAndView;
    }

    @PostMapping("/user/register")
    public ResultResponse userRegister(@RequestParam(name="userName")String userName, @RequestParam(name="userPassword")String userPassword){
        ResultResponse resultResponse;
        if(userName==null || userPassword==null){
            resultResponse=new ResultResponse(407,"用户名或密码不能为空！");
            return resultResponse;
        }
        if(userService.validUserName(userName)!=null){
            resultResponse=new ResultResponse(407,"用户名已存在！");
            return resultResponse;
        }
        else {
            User user=new User();
            String salt= StringUtils.createStringRandom(6);
            user.setUserName(userName);
            user.setUserPassword(MD5Util.md5(userPassword+salt));
            user.setSalt(salt);
            user.setStatus(1);
            if(1==userService.addUser(user) ){
                UserInfo userInfo=new UserInfo();
                userInfo.setUid(user.getUid());
                userInfo.setUserName(userName);
                userInfoService.addUserInfo(userInfo);
                resultResponse=new ResultResponse<String>(200,"用户注册成功！","/");
                return resultResponse;
            }
            else {
                resultResponse=new ResultResponse(407,"用户注册失败,请稍后再试！");
                return resultResponse;
            }
        }
    }

    @GetMapping("/")
    public ModelAndView rootPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/login");
        return modelAndView;
    }

    @PostMapping("/user/login")
    public ResultResponse validUser(User user, HttpSession httpSession){
        ResultResponse<String > resultResponse;
        User user1=userService.findByName(user.getUserName());
        if(user1!=null){
            user.setUserPassword(MD5Util.md5(user.getUserPassword()+user1.getSalt()));
            user1=userService.validUser(user);
            if(user1 != null && user1.getStatus()!= 0){
                httpSession.setAttribute("userId",user1.getUid());
                httpSession.setAttribute("userName",user1.getUserName());
                resultResponse=new ResultResponse<String>(200,"登录成功！","/user/index");
                return  resultResponse;
            }
            else {
                resultResponse=new ResultResponse<>(407,"用户名或密码有错误,或者此账户已被冻结！");
                return resultResponse;
            }
        }
        else {
            resultResponse=new ResultResponse<>(407,"用户不存在！");
            return resultResponse;
        }
    }

    @GetMapping("/user/index")
    public ModelAndView userPage(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/index");
        modelAndView.addObject("userId",httpSession.getAttribute("userId"));
        modelAndView.addObject("userName",httpSession.getAttribute("userName"));
        return modelAndView;
    }

    @GetMapping("/user/welcome")
    public ModelAndView welcoem(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/welcome");
//        User user=userService.findById((Integer)httpSession.getAttribute("userId"));
        modelAndView.addObject("userName",httpSession.getAttribute("userName"));
        modelAndView.addObject("articleCount",articleService.countArticleByUid((Integer) httpSession.getAttribute("userId")));
        modelAndView.addObject("commentCount",commentService.countCommentByUid((Integer) httpSession.getAttribute("userId")));
        modelAndView.addObject("categoryCount",articleCategoryService.countArticleCategory());
        return modelAndView;
    }

    @GetMapping("/user/editUserInfo")
    public ModelAndView getEditUserInfoPage(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userPage/userInfo-edit");
        UserInfo userInfo = userInfoService.findByUid((Integer) httpSession.getAttribute("userId"));
        modelAndView.addObject("userInfo",userInfo);
        return modelAndView;
    }

    @GetMapping("/user/userInfo")
    public ResultResponse getUserInfo(HttpSession httpSession){

        ResultResponse resultResponse;
        UserInfo userInfo=userInfoService.findByUid((Integer)httpSession.getAttribute("userId"));
        if(userInfo!=null){
            resultResponse=new ResultResponse(200,"用户详细信息获取成功！",userInfo);
            return resultResponse;
        }
        else {
            resultResponse=new ResultResponse(407,"用户信息可能为空,获取失败！");
            return resultResponse;
        }
    }

    @GetMapping("/user/updateUserInfo")
    public  ModelAndView getUpdateUserInfoPage(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userPage/userInfo-edit");
        modelAndView.addObject("userInfo",userInfoService.findByUid((Integer) httpSession.getAttribute("userId")));
        return modelAndView;
    }

    @PostMapping("/user/updateUserInfo")
    public ResultResponse updateUserInfo(UserInfo userInfo){
        ResultResponse resultResponse = null;
        if(userInfoService.updateUserInfo(userInfo) == 1){
            resultResponse = new ResultResponse(200,"更新用户信息成功！");
        }
        else {
            resultResponse = new ResultResponse(407,"更新用户信息失败！");
        }
        return resultResponse;
    }

    @GetMapping("/user/updateUser")
    public ModelAndView updateUser(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userPage/user-edit");
        modelAndView.addObject("userName",(String)httpSession.getAttribute("userName"));
        return modelAndView;
    }

    @PostMapping("/user/updateUser")
    public ResultResponse updateUser(@RequestParam("userName")String userName,@RequestParam("newPwd") String pwd,HttpSession httpSession){
        ResultResponse<String> resultResponse;
        User user = userService.findById((Integer)httpSession.getAttribute("userId"));
        user.setUserName(userName);
        user.setUserPassword(MD5Util.md5(pwd+user.getSalt()));
        if(1 == userService.updateUser(user)){
            resultResponse=new ResultResponse<String>(200,"修改成功！","/");
        }
        else {
            resultResponse=new ResultResponse<String>(407,"修改失败！");
        }
        return resultResponse;
    }

    @PostMapping("/user/verifyPassword")
    public ResultResponse verifyPassword(@RequestParam("oldPwd")String password, HttpSession httpSession){
        ResultResponse resultResponse;
        User user = userService.findById((Integer)httpSession.getAttribute("userId"));
        if(user.getUserPassword().equals(MD5Util.md5(password+user.getSalt()))){
            resultResponse=new ResultResponse(200,"验证成功！");
        }
        else {
            resultResponse=new ResultResponse(407,"密码错误！");
        }
        return resultResponse;
    }

    @GetMapping("/user/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/login");
        return modelAndView;
    }

    @GetMapping("/user/reload")
    public boolean reload(HttpSession httpSession){
        Integer uid = (Integer) httpSession.getAttribute("userId");
        return uid != null && uid != 0;
    }

}
