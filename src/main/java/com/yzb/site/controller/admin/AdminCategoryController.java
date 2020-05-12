package com.yzb.site.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzb.site.common.CodeEnum;
import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.ArticleCategory;
import com.yzb.site.service.ArticleCategoryService;
import com.yzb.site.service.ArticleService;
import com.yzb.site.service.RelationArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminCategoryController {

    @Autowired
    private ArticleCategoryService articleCategoryService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private RelationArticleCategoryService relationArticleCategoryService;

    @GetMapping("/categoryPage")
    public ModelAndView getCategoryPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminPage/category-list");
        return modelAndView;
    }

    @GetMapping("/category/list")
    public ResultResponse categoryList(@RequestParam(name = "page",required = false)Integer currentPage,@RequestParam(name = "limit",required = false)Integer pageSize,@RequestParam(name = "categoryName",required = false)String categoryName){

        ResultResponse resultResponse=null;
        List<ArticleCategory> categoryList = null;
        PageInfo<ArticleCategory> categoryPageInfo = null;

        if(currentPage != null && pageSize != null){
            PageHelper.startPage(currentPage,pageSize);
        }

        if(categoryName == null){
            categoryList=articleCategoryService.findAll();
        }
        else {
            categoryList=articleCategoryService.findByName(categoryName);
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

    @GetMapping("/category/addPage")
    public ModelAndView getCategoryAddPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminPage/category-add");
        return modelAndView;
    }

    @PostMapping("/category")
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

//    @PostMapping("/category/update")
    @RequestMapping(path = "/category",method = RequestMethod.PUT)
    public ResultResponse updateCategory(ArticleCategory articleCategory){
        ResultResponse resultResponse=null;
        articleCategory.setUpdateTime(new Date());
        if(articleCategoryService.updateArticleCategory(articleCategory) == 1){
            resultResponse=new ResultResponse(0,"更新分类信息成功！");
            return resultResponse;
        }
        else {
            resultResponse=new ResultResponse(407,"更新分类信息失败！");
            return resultResponse;
        }

    }

    /*
     * @param 分类id
     * 删除此分类信息,并将此分类下文章合并至默认分类下 即更新关联文章和分类表的分类.
     */
//    @PostMapping("/category/delete")
    @RequestMapping(path = "/category",method = RequestMethod.DELETE)
    public ResultResponse deleteCategory(Integer categoryId){
        ResultResponse resultResponse = null;
        //通过分类id删除分类
        if(articleCategoryService.deleteById(categoryId) == 1){
            //查询此分类下是否关联有文章，有则重置
            if(relationArticleCategoryService.findByCategoryId(categoryId).isEmpty() == false){
                if(relationArticleCategoryService.updateRelation(categoryId) == 1){
                    resultResponse = new ResultResponse(1,"删除并重置分类下文章为默认分类成功！");
                }
                else {
                    resultResponse = new ResultResponse(0,"删除分类成功，重置分类下文章为默认分类失败！");
                }
            }
            else {
                resultResponse = new ResultResponse(1,"删除此分类成功，此分类下无文章");
            }
        }
        else {
            resultResponse = new ResultResponse(0,"删除分类失败！");
        }
        return resultResponse;
    }
}
