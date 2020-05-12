package com.yzb.site.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzb.site.common.CodeEnum;
import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.ArticleCategory;
import com.yzb.site.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
public class UserCategoryController {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @GetMapping("/user/categoryListPage")
    public ModelAndView getCategoryPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/category-list");
        return modelAndView;
    }

    @GetMapping("/user/category/list")
    public ResultResponse categoryList(@RequestParam(name = "page",required = false)Integer currentPage, @RequestParam(name = "limit",required = false)Integer pageSize, @RequestParam(name = "categoryName",required = false)String categoryName){

        ResultResponse resultResponse=null;
        List<ArticleCategory> categoryList = null;
        PageInfo<ArticleCategory> categoryPageInfo = null;

        if(currentPage != null && pageSize != null){
            PageHelper.startPage(currentPage,pageSize);
        }

        if(categoryName == null){
            categoryList = articleCategoryService.findAll();
        }
        else {
            categoryList = articleCategoryService.findByName(categoryName);
        }

        categoryPageInfo = new PageInfo<>(categoryList);
        if(categoryList.isEmpty() == false){
            resultResponse=new ResultResponse(0,"查询成功！");
            resultResponse.setData(categoryPageInfo);
            return resultResponse;
        }
        else {
            resultResponse=new ResultResponse(407,"查询失败！");
            resultResponse.setData(categoryPageInfo);
            return resultResponse;
        }
    }

    @GetMapping("user/category/addPage")
    public ModelAndView getCategoryAddPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/category-add");
        return modelAndView;
    }

    @PostMapping("user/category")
    public ResultResponse addCategory(ArticleCategory articleCategory){
        ResultResponse resultResponse = null;
        articleCategory.setUpdateTime(new Date());
        if(articleCategoryService.addArticleCategory(articleCategory) == 1){
            resultResponse = new ResultResponse(200,"添加分类成功！");
        }
        else {
            resultResponse = new ResultResponse(CodeEnum.FAIL);
        }
        return resultResponse;
    }

    @GetMapping("/user/articleCategories")
    public ResultResponse getCategory(){
        ResultResponse resultResponse = null;
        List<ArticleCategory> articleCategories = articleCategoryService.findAll();
        if(articleCategories.isEmpty() == false){
            resultResponse = new ResultResponse(0,"查询成功!",articleCategories);
        }
        else {
            resultResponse = new ResultResponse(1,"查询失败!");
        }
        return resultResponse;
    }

}
