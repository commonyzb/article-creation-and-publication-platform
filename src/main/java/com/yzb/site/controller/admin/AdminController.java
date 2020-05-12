package com.yzb.site.controller.admin;


import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.Admin;
import com.yzb.site.service.*;
import com.yzb.site.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleCategoryService articleCategoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminPage/login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ResultResponse validAdmin(Admin admin, HttpSession httpSession){
        ResultResponse<String> resultResponse;
        if(admin.getAdminName()==null || admin.getAdminPassword()==null){
            resultResponse=new ResultResponse<>(407,"用户名或密码不能为空！");
            return resultResponse;
        }
        else {
            admin.setAdminPassword(MD5Util.md5(admin.getAdminPassword()));
            Admin admin1=adminService.validAdmin(admin);
            if(admin1!= null && 0!=admin1.getStatus()){
                httpSession.setAttribute("adminId",admin1.getId());
                httpSession.setAttribute("adminName",admin1.getAdminName());
                resultResponse=new ResultResponse<>(200,"登录成功！");
                resultResponse.setData("/admin/index");
                return resultResponse;
            }
            else {
                resultResponse=new ResultResponse<>(407,"帐号密码错误或帐号已被冻结！");
                return resultResponse;
            }
        }
    }

    @GetMapping("/index")
    public ModelAndView getAdminPage(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage/index");
        modelAndView.addObject("adminName",(String)httpSession.getAttribute("adminName"));
        return modelAndView;
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(HttpSession httpSession){
        Integer adminId=(Integer)httpSession.getAttribute("adminId");
//        Admin admin=adminService.findById(adminId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage/welcome");
        modelAndView.addObject("adminName",httpSession.getAttribute("adminName"));
        modelAndView.addObject("userCount",userService.countUser());
        modelAndView.addObject("articleCount",articleService.countArticle());
        modelAndView.addObject("commentCount",commentService.countComment());
        modelAndView.addObject("categoryCount",articleCategoryService.countArticleCategory());
        return modelAndView;
    }

    @GetMapping("/adminInfo")
    public ModelAndView editAdminInfo(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/adminPage/adminInfo-edit");
        modelAndView.addObject("adminName",(String)httpSession.getAttribute("adminName"));
        return modelAndView;
    }

    @PostMapping("/adminInfo")
    public ResultResponse updateAdminInfo(@RequestParam("adminName")String adminName,@RequestParam("newPwd") String pwd,HttpSession httpSession){
        ResultResponse<String> resultResponse;
        Admin admin=adminService.findById((Integer)httpSession.getAttribute("adminId"));
        admin.setAdminName(adminName);
        admin.setAdminPassword(MD5Util.md5(pwd));
        if(1==adminService.updateAdmin(admin)){
            resultResponse=new ResultResponse<String>(200,"修改成功！","/admin/login");
        }
        else {
            resultResponse=new ResultResponse<String>(407,"修改失败！");
        }
        return resultResponse;
    }

    @PostMapping("/verifyPassword")
    public ResultResponse verifyPassword(@RequestParam("oldPwd")String password, HttpSession httpSession){
        ResultResponse resultResponse;
        Admin admin=adminService.findById((Integer)httpSession.getAttribute("adminId"));
        if(admin.getAdminPassword().equals(MD5Util.md5(password))){
            resultResponse=new ResultResponse(200,"验证成功！");
        }
        else {
            resultResponse=new ResultResponse(407,"密码错误！");
        }
        return resultResponse;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminPage/login");
        return modelAndView;
    }

    @GetMapping("/reload")
    public boolean reload(HttpSession httpSession){
        Integer adminId = (Integer) httpSession.getAttribute("adminId");
        return adminId != null && adminId != 0;
    }

}
