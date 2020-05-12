package com.yzb.site.service;

import com.yzb.site.entity.Comment;

import java.util.List;

public interface CommentService {

    Integer addComment(Comment comment);

    Integer deleteComment(Comment comment);

    Integer deleteById(Integer id);

    Integer updateComment(Comment comment);

    Integer updateCommentStatus(Integer id,Integer status);

    Integer countComment();

    Integer countCommentByUid(Integer uid);

    Comment findById(Integer id);

    List<Comment> findByFirstFloor(Integer aid);

    List<Comment> findByParentId(Integer parentId);

    List<Comment> findByAid(Integer aid);

    List<Comment> findByFromUid(Integer uid);

    List<Comment> findByToUid(Integer uid);

    List<Comment> findByStatus(Integer status);

    List<Comment> findAll();

}
