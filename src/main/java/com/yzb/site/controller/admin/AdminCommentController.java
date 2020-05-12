package com.yzb.site.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzb.site.common.ResultResponse;
import com.yzb.site.entity.Comment;
import com.yzb.site.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminCommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentPage")
    public ModelAndView getCommentPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("adminPage/comment-list");
        return modelAndView;
    }

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public ResultResponse deleteComment(@RequestParam("id") int id){
        ResultResponse resultResponse = new ResultResponse();
        if (commentService.deleteById(id) == 1){
            resultResponse.setcode(0);
            resultResponse.setMessage("评论删除成功！");
        }
        else {
            resultResponse.setcode(1);
            resultResponse.setMessage("评论删除失败！");
        }
        return resultResponse;
    }

    @GetMapping("/comment/list")
    public ResultResponse getCommentList(@RequestParam(name = "page") int currentPage, @RequestParam(name = "limit") int pageSize){
        List<Comment> commentList = null;
        PageInfo<Comment> commentPageInfo = null;
        ResultResponse resultResponse = null;

        PageHelper.startPage(currentPage,pageSize);
        commentList = commentService.findAll();
        commentPageInfo = new PageInfo<>(commentList);
        if(commentList.isEmpty() == false){
            resultResponse = new ResultResponse(0,"获取评论成功！");
            resultResponse.setData(commentPageInfo);
        }
        else {
            resultResponse = new ResultResponse(1,"获取评论失败！");
        }
        return resultResponse;
    }

    @PostMapping("/comment/changeCommentStatus")
    public ResultResponse changeCommentStatus(@RequestParam(name = "id") int id,@RequestParam(name="status") int status){
        ResultResponse resultResponse = null;
        if(commentService.updateCommentStatus(id,status) == 1){
            resultResponse = new ResultResponse(1,"状态修改成功！");
        }
        else {
            resultResponse = new ResultResponse(0,"状态修改失败！");
        }
        return resultResponse;
    }

}
