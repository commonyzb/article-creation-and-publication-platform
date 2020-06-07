package com.yzb.site.service;

import com.yzb.site.entity.Article;

import java.util.List;

public interface ArticleService {

    /*
     * CRUD
     */
    int addArticle(Article article);

    int deleteArticle(Article article);

    int deleteArticle(int id);

    int updateArticle(Article article);

    int updateArticleStatus(int aid,int status);

    int updateEnableCommentStatus(int aid,int enableComment);

    int updateAuditStatus(int aid,int auditStatus);

    int countArticle();

    int countArticleByUid(int uid);

    Article findById(int id);

    List<Article> findByUid(int uid);

    List<Article> findByTitle(String title);

    List<Article> findByCategoryName(String categoryName);

    List<Article> findByCategoryId(int id);

    List<Article> findByStatus(int status);

    List<Article> userFindByCategoryName(String categoryName);

    List<Article> userFindByTitle(String title);

    List<Article> findAll();

}
