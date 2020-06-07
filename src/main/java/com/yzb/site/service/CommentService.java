package com.yzb.site.service;

import com.yzb.site.entity.Comment;

import java.util.List;

public interface CommentService {

    int addComment(Comment comment);

    int deleteComment(Comment comment);

    int deleteById(int id);

    int updateComment(Comment comment);

    int updateCommentStatus(int id,int status);

    int countComment();

    int countCommentByUid(int uid);

    Comment findById(int id);

    List<Comment> findByFirstFloor(int aid);

    List<Comment> findByParentId(int parentId);

    List<Comment> findByAid(int aid);

    List<Comment> findByFromUid(int uid);

    List<Comment> findByToUid(int uid);

    List<Comment> findByStatus(int status);

    List<Comment> findAll();

}
