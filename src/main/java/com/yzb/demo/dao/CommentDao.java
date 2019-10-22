package com.yzb.demo.dao;

import com.yzb.demo.entity.Article;
import com.yzb.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {
    /*
     * CRUD
     */

    boolean addComment(CommentDao comment);

    boolean deleteById(Integer id);

    boolean deleteComment(CommentDao comment);

    Integer deleteComment(List<CommentDao> comments);

    boolean updateComment(CommentDao comment);

    CommentDao findById(Integer id);

    CommentDao findByComment(CommentDao comment);

    List<CommentDao> findByUser(User user);

    List<CommentDao> findByParentId(Integer id);

    List<CommentDao> findByAid(Integer aid);

    List<CommentDao> findByArticle(Article article);

    List<CommentDao> find(List<CommentDao> comments);

}
