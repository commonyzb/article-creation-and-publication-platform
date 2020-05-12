package com.yzb.site.service.impl;

import com.yzb.site.dao.CommentDao;
import com.yzb.site.entity.Comment;
import com.yzb.site.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Integer addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public Integer deleteComment(Comment comment) {
        return commentDao.deleteComment(comment);
    }

    @Override
    public Integer deleteById(Integer id) {
        return commentDao.deleteById(id);
    }

    @Override
    public Integer updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public Integer updateCommentStatus(Integer id, Integer status) {
        return commentDao.updateCommentStatus(id,status);
    }

    @Override
    public Integer countComment() {
        return commentDao.countComment();
    }

    @Override
    public Integer countCommentByUid(Integer uid) {
        return commentDao.countCommentByUid(uid);
    }

    @Override
    public Comment findById(Integer id) {
        return commentDao.findById(id);
    }

    @Override
    public List<Comment> findByFirstFloor(Integer aid) {
        return commentDao.findByFirstFloor(aid);
    }

    @Override
    public List<Comment> findByParentId(Integer parentId) {
        return commentDao.findByParentId(parentId);
    }

    @Override
    public List<Comment> findByAid(Integer aid) {
        return commentDao.findByAid(aid);
    }

    @Override
    public List<Comment> findByFromUid(Integer uid) {
        return commentDao.findByFromUid(uid);
    }

    @Override
    public List<Comment> findByToUid(Integer uid) {
        return commentDao.findByToUid(uid);
    }


    @Override
    public List<Comment> findByStatus(Integer status) {
        return commentDao.findByStatus(status);
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }
}
