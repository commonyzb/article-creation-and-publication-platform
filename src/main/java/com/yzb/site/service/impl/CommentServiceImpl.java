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
    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public int deleteComment(Comment comment) {
        return commentDao.deleteComment(comment);
    }

    @Override
    public int deleteById(int id) {
        return commentDao.deleteById(id);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public int updateCommentStatus(int id, int status) {
        return commentDao.updateCommentStatus(id,status);
    }

    @Override
    public int countComment() {
        return commentDao.countComment();
    }

    @Override
    public int countCommentByUid(int uid) {
        return commentDao.countCommentByUid(uid);
    }

    @Override
    public Comment findById(int id) {
        return commentDao.findById(id);
    }

    @Override
    public List<Comment> findByFirstFloor(int aid) {
        return commentDao.findByFirstFloor(aid);
    }

    @Override
    public List<Comment> findByParentId(int parentId) {
        return commentDao.findByParentId(parentId);
    }

    @Override
    public List<Comment> findByAid(int aid) {
        return commentDao.findByAid(aid);
    }

    @Override
    public List<Comment> findByFromUid(int uid) {
        return commentDao.findByFromUid(uid);
    }

    @Override
    public List<Comment> findByToUid(int uid) {
        return commentDao.findByToUid(uid);
    }


    @Override
    public List<Comment> findByStatus(int status) {
        return commentDao.findByStatus(status);
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }
}
