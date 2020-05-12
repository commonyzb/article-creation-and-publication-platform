package com.yzb.site.service;

import com.yzb.site.entity.Article;

import java.util.List;

public interface ArticleService {

    /*
     * CRUD
     */
    Integer addArticle(Article article);

    Integer deleteArticle(Article article);

    Integer deleteArticle(Integer id);

    Integer updateArticle(Article article);

    Integer updateArticleStatus(Integer aid,Integer status);

    Integer updateEnableCommentStatus(Integer aid,Integer enableComment);

    Integer updateAuditStatus(Integer aid,Integer auditStatus);

    Integer countArticle();

    Integer countArticleByUid(Integer uid);

    Article findById(Integer id);

    List<Article> findByUid(Integer uid);

    List<Article> findByTitle(String title);

    List<Article> findByCategoryName(String categoryName);

    List<Article> findByCategoryId(Integer id);

    List<Article> findByStatus(Integer status);

    List<Article> userFindByCategoryName(String categoryName);

    List<Article> userFindByTitle(String title);

    List<Article> findAll();

}
