package com.yzb.site.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.Article;
import com.yzb.site.entity.Comment;
import com.yzb.site.entity.User;
import com.yzb.site.service.ArticleCategoryService;
import com.yzb.site.service.ArticleService;
import com.yzb.site.service.CommentService;
import com.yzb.site.service.UserService;
import com.yzb.site.vo.ArticleVO;
import com.yzb.site.vo.CategoryVO;
import com.yzb.site.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminArticleController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleCategoryService articleCategoryService;

    @GetMapping("/articlePage")
    public ModelAndView getArticleListPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminPage/article-list");
        return modelAndView;
    }

    @GetMapping("/article")
    public ModelAndView articleDetail(@RequestParam(name = "aid") Integer aid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage/article-detail");
        Article article = articleService.findById(aid);
        ArticleVO articleVO = new ArticleVO(article);
        List<CategoryVO> categories = articleCategoryService.categoryVOSFindByAid(aid);
        articleVO.setCategoryVOS(categories);
        modelAndView.addObject("articleVO",articleVO);
        List<Comment> comments = commentService.findByFirstFloor(aid);
        List<CommentVO> commentVOS = new ArrayList<CommentVO>();
        Iterator<Comment> iterator = comments.iterator();
        while (iterator.hasNext()){
            Comment comment = iterator.next();
            User fromUser = userService.findById(comment.getFromUid());
            User toUser = userService.findById(comment.getToUid());
            CommentVO commentVO = new CommentVO(comment);
            commentVO.setFromUserName(fromUser.getUserName());
            commentVO.setToUserName(toUser.getUserName());
            List<CommentVO> replyVOS = new ArrayList<CommentVO>();
            List<Comment> replyComments = commentService.findByParentId(comment.getId());
            Iterator<Comment> iterator1 = replyComments.iterator();
            while (iterator1.hasNext()){
                Comment comment1 = iterator1.next();
                User fromUser1 = userService.findById(comment.getFromUid());
                User toUser1 = userService.findById(comment.getToUid());
                CommentVO commentVO1 = new CommentVO(comment1);
                commentVO1.setFromUserName(fromUser1.getUserName());
                commentVO1.setToUserName(toUser1.getUserName());
               replyVOS.add(commentVO1);
            }
            commentVO.setReplys(replyVOS);
            commentVOS.add(commentVO);
        }
        modelAndView.addObject("commentVOS",commentVOS);
        return modelAndView;
    }

    @GetMapping("/article/edit")
    public ModelAndView getArticleEditPage(@RequestParam("aid") Integer aid){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminPage/article-edit");
        Article article = articleService.findById(aid);
        modelAndView.addObject(article);
        return modelAndView;
    }

    @PostMapping("/article/edit")
    public ResultResponse editArticle(Article article, HttpSession httpSession){
        ResultResponse resultResponse = null;
        if(httpSession.getAttribute("adminId")!=null){
            resultResponse = new ResultResponse(1,"无权限修改文章！");
        }
        else {
            resultResponse = new ResultResponse(0,"无权限修改文章！");
        }
        return resultResponse;
    }

    @GetMapping("/article/list")
    public ResultResponse getArticleList(@RequestParam(name = "page") int currentPage,@RequestParam(name = "limit") int pageSize,@RequestParam(name = "articleTitle",required = false)String articleTitle){

        List<Article> articleList = null;
        PageInfo<Article> articlePageInfo = null;
        ResultResponse resultResponse = null;

        PageHelper.startPage(currentPage,pageSize);
        if( articleTitle == null){
            articleList = articleService.findAll();
        }
        else {
            articleList = articleService.findByTitle(articleTitle);
        }
        articlePageInfo = new PageInfo<>(articleList);
        if(articleList.isEmpty() == false){
            resultResponse=new ResultResponse(0,"获取文章成功！");
            resultResponse.setData(articlePageInfo);
            return resultResponse;
        }
        else {
            resultResponse=new ResultResponse(407,"未找到文章！！！");
            resultResponse.setData(articlePageInfo);
            return resultResponse;
        }
    }

    @RequestMapping(path = "/article",method = RequestMethod.DELETE)
    public ResultResponse deleteArticle(Integer aid){
        ResultResponse resultResponse = null;
        if(articleService.deleteArticle(aid) == 1){
            resultResponse = new ResultResponse(1,"删除文章成功！");
        }
        else {
            resultResponse = new ResultResponse(0,"删除文章失败！");
        }
        return resultResponse;
    }


    @PostMapping("/article/changeEnableCommentStatus")
    public ResultResponse changeEnableCommentStatus(@RequestParam("aid") int aid,@RequestParam("enableComment") int enableComment){
        ResultResponse resultResponse = null;
        if (articleService.updateEnableCommentStatus(aid,enableComment) == 1){
            resultResponse = new ResultResponse(1,"状态更新成功！");
        }
        else {
            resultResponse = new ResultResponse(0,"状态更新失败！");
        }
        return resultResponse;
    }

    @PostMapping("/article/changeArticleStatus")
    public ResultResponse changeArticleStatus(@RequestParam("aid") int aid,@RequestParam("status") int status){
        ResultResponse resultResponse = null;
        if (articleService.updateArticleStatus(aid,status) == 1){
            resultResponse = new ResultResponse(1,"状态更新成功！");
        }
        else {
            resultResponse = new ResultResponse(0,"状态更新失败！");
        }
        return resultResponse;
    }

    @PostMapping("/article/changeAuditStatus")
    public ResultResponse changeAuditStatus(@RequestParam("aid") int aid,@RequestParam("auditStatus") int auditStatus){
        ResultResponse resultResponse = null;
        if (articleService.updateAuditStatus(aid,auditStatus) == 1){
            resultResponse = new ResultResponse(1,"状态更新成功！");
        }
        else {
            resultResponse = new ResultResponse(0,"状态更新失败！");
        }
        return resultResponse;
    }

}
