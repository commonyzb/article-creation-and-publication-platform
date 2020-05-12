package com.yzb.site.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.Article;
import com.yzb.site.entity.Comment;
import com.yzb.site.service.ArticleService;
import com.yzb.site.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserCommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @PostMapping("/user/comment")
    public ResultResponse addComment(Comment comment,HttpSession httpSession){
        ResultResponse resultResponse = null;
        if((Integer)httpSession.getAttribute("userId") != null){
            if(comment.getFromUid() == null){
                Article article = articleService.findById(comment.getAid());
                comment.setFromUid((Integer) httpSession.getAttribute("userId"));
                comment.setToUid(article.getUid());
                System.out.println(comment.toString());
                if(commentService.addComment(comment) == 1){
                    resultResponse = new ResultResponse(0,"评论提交成功！");
                }
                else {
                    resultResponse = new ResultResponse(1,"评论失败");
                }
            }
            else {
                if (commentService.addComment(comment) == 1){
                    resultResponse = new ResultResponse(0,"评论提交成功！");
                }
                else {
                    resultResponse = new ResultResponse(1,"评论失败");
                }
            }
        }
        else {
            resultResponse = new ResultResponse(0,"无评论权限!请登录后再评论...");
        }
        return resultResponse;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/user/comment")
    public ResultResponse delComment(Integer id,HttpSession httpSession){
        ResultResponse resultResponse = null;
        resultResponse.setcode(1);
        resultResponse.setMessage("删除失败，权限不足！");
        return resultResponse;
    }

    @GetMapping("/user/commentListFromMe")
    public ModelAndView getCommentListFromMePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userPage/comment-list-from-me");
        return modelAndView;
    }

    @GetMapping("/user/commentListToMe")
    public ModelAndView getCommentListToMePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userPage/comment-list-to-me");
        return modelAndView;
    }

    @GetMapping("/user/comment/listFromMe")
    public ResultResponse getCommentListFromMe(@RequestParam(name = "page") int currentPage, @RequestParam(name = "limit") int pageSize, HttpSession httpSession){
        List<Comment> commentList = null;
        PageInfo<Comment> commentPageInfo = null;
        ResultResponse resultResponse = null;

        PageHelper.startPage(currentPage,pageSize);
        commentList = commentService.findByFromUid((Integer) httpSession.getAttribute("userId"));
        commentPageInfo = new PageInfo<>(commentList);
        if(commentList.isEmpty() == false){
            resultResponse = new ResultResponse(0,"获取评论成功！");
            resultResponse.setData(commentPageInfo);
        }
        else {
            resultResponse = new ResultResponse(1,"获取评论失败，评论可能为空！");
        }
        return resultResponse;

    }
    @GetMapping("/user/comment/listToMe")
    public ResultResponse getCommentListToMe(@RequestParam(name = "page") int currentPage, @RequestParam(name = "limit") int pageSize,HttpSession httpSession){
        List<Comment> commentList = null;
        PageInfo<Comment> commentPageInfo = null;
        ResultResponse resultResponse = null;

        PageHelper.startPage(currentPage,pageSize);
        commentList = commentService.findByToUid((Integer) httpSession.getAttribute("userId"));
        commentPageInfo = new PageInfo<>(commentList);
        if(commentList.isEmpty() == false){
            resultResponse = new ResultResponse(0,"获取评论成功！");
            resultResponse.setData(commentPageInfo);
        }
        else {
            resultResponse = new ResultResponse(1,"获取评论失败,评论可能为空！");
        }
        return resultResponse;

    }

}
