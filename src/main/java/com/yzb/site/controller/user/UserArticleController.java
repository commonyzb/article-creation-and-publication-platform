package com.yzb.site.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.Article;
import com.yzb.site.entity.Comment;
import com.yzb.site.entity.RelationArticleCategory;
import com.yzb.site.entity.User;
import com.yzb.site.service.*;
import com.yzb.site.vo.ArticleVO;
import com.yzb.site.vo.CategoryVO;
import com.yzb.site.vo.CommentVO;
import com.yzb.site.vo.NewArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleCategoryService articleCategoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private RelationArticleCategoryService relationArticleCategoryService;

    @GetMapping("/user/articleEditPage")
    public ModelAndView getArticleEditPage(HttpSession httpSession){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("/userPage/article-edit");
        return mv;
    }

//    @GetMapping("/user/article")
//    public ModelAndView articleDetail(@RequestParam(name = "aid") Integer aid){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("article-detail1");
//        Article article = articleService.findById(aid);
//        modelAndView.addObject("article",article);
//        return modelAndView;
//    }

    @PostMapping("/user/article")
    public ResultResponse addArticle(NewArticleVO newArticleVO, HttpSession httpSession){
        ResultResponse resultResponse = null;
        Article article = new Article();
        article.setAuthor((String) httpSession.getAttribute("userName"));
        article.setUid((Integer) httpSession.getAttribute("userId"));
        article.setTitle(newArticleVO.getTitle());
        article.setSummary(newArticleVO.getSummary());
        article.setContent(newArticleVO.getContent());
        article.setEnableComment(newArticleVO.getEnableComment());
        article.setStatus(newArticleVO.getStatus());
        if(articleService.addArticle(article) == 1){
//            if(newArticleVO.getCategories() == null){
//                RelationArticleCategory relationArticleCategory = new RelationArticleCategory();
//                relationArticleCategory.setAid(article.getAid());
//                relationArticleCategory.setCategoryId(3);
//                relationArticleCategoryService.addRelation(relationArticleCategory);
//            }
//            else {
            Iterator<Integer> iterator = newArticleVO.getCategories().iterator();
            while (iterator.hasNext()){
                RelationArticleCategory relationArticleCategory = new RelationArticleCategory();
                relationArticleCategory.setAid(article.getAid());
                Integer categoryId = iterator.next();
                relationArticleCategory.setCategoryId(categoryId);
                relationArticleCategoryService.addRelation(relationArticleCategory);
//                    }
//                System.out.println("未分类");
            }
            resultResponse = new ResultResponse(200,"文章保存成功！");
        }
        else {
            resultResponse = new ResultResponse(407,"文章保存失败！");
        }
        return resultResponse;
    }

    @RequestMapping(value = "/user/article",method = RequestMethod.PUT)
    public ResultResponse updateArticle(NewArticleVO newArticleVO, HttpSession httpSession){
        ResultResponse resultResponse = null;
        Article article = new Article();
        article.setAid(newArticleVO.getAid());
        article.setAuthor((String) httpSession.getAttribute("userName"));
        article.setUid((Integer) httpSession.getAttribute("userId"));
        article.setTitle(newArticleVO.getTitle());
        article.setSummary(newArticleVO.getSummary());
        article.setContent(newArticleVO.getContent());
        article.setEnableComment(newArticleVO.getEnableComment());
        article.setStatus(newArticleVO.getStatus());
        if(articleService.updateArticle(article) == 1){
            Iterator<Integer> iterator = newArticleVO.getCategories().iterator();
            while (iterator.hasNext()){
                RelationArticleCategory relationArticleCategory = new RelationArticleCategory();
                relationArticleCategory.setAid(article.getAid());
                Integer categoryId = iterator.next();
                relationArticleCategory.setCategoryId(categoryId);
                relationArticleCategoryService.addRelation(relationArticleCategory);
            }
            resultResponse = new ResultResponse(200,"文章更新成功！");
        }
        else {
            resultResponse = new ResultResponse(407,"文章更新失败！");
        }
        return resultResponse;
    }

    @GetMapping("/user/article")
    public ModelAndView articleDetail(@RequestParam Integer aid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage/article-detail");
        Article article = articleService.findById(aid);
//        article.setContent(MarkDownUtils.mdToHtml(article.getContent()));
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

    @GetMapping("/user/article/edit")
    public ModelAndView getArticleEditPage(@RequestParam("aid") Integer aid){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("userPage/article-edit");
        Article article = articleService.findById(aid);
        modelAndView.addObject("article",article);
        return modelAndView;
    }

    @GetMapping("/user/articleListPage")
    public  ModelAndView getArticleListPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userPage/article-list");
        return modelAndView;
    }

    @GetMapping("/user/article/list")
    public ResultResponse getArticleList(@RequestParam(name = "page") int currentPage, @RequestParam(name = "limit") int pageSize,@RequestParam(name = "articleTitle",required = false)String articleTitle,HttpSession httpSession){
        ResultResponse resultResponse = null;
        List<Article> articleList = null;
        PageInfo<Article> articlePageInfo = null;

        PageHelper.startPage(currentPage,pageSize);
        if( articleTitle == null){
            articleList = articleService.findByUid((Integer)httpSession.getAttribute("userId"));
        }
        else {
            articleList = articleService.userFindByTitle(articleTitle);
        }
        articlePageInfo = new PageInfo<>(articleList);
        if(articleList.isEmpty() == false){
            resultResponse=new ResultResponse(0,"获取文章成功！");
            resultResponse.setData(articlePageInfo);
        }
        else {
            resultResponse=new ResultResponse(407,"未找到文章！！！");
            resultResponse.setData(articlePageInfo);
        }
        return resultResponse;
    }

    @RequestMapping(path = "/user/article",method = RequestMethod.DELETE)
    public ResultResponse deleteArticle(Integer aid,HttpSession httpSession){
        ResultResponse resultResponse = null;
        if(articleService.findById(aid).getUid()==(Integer)httpSession.getAttribute("userId") && articleService.deleteArticle(aid) == 1){
            resultResponse = new ResultResponse(1,"删除文章成功！");
        }
        else {
            resultResponse = new ResultResponse(0,"删除文章失败,您可能无权限删除文章！");
        }
        return resultResponse;
    }


    @PostMapping("/user/article/changeEnableCommentStatus")
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

    @PostMapping("/user/article/changeArticleStatus")
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
}
