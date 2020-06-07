package com.yzb.site.service.impl;

import com.yzb.site.dao.ArticleDao;
import com.yzb.site.entity.Article;
import com.yzb.site.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public int addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public int deleteArticle(Article article) {
        return articleDao.deleteArticle(article);
    }

    @Override
    public int deleteArticle(int id) {
        return articleDao.deleteById(id);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public int updateArticleStatus(int aid, int status) {
        return articleDao.updateArticleStatus(aid,status);
    }

    @Override
    public int updateEnableCommentStatus(int aid, int enableComment) {
        return articleDao.updateEnableComment(aid,enableComment);
    }

    @Override
    public int updateAuditStatus(int aid, int auditStatus) {
        return articleDao.updateAuditStatus(aid,auditStatus);
    }

    @Override
    public int countArticle() {
        return articleDao.countArticle();
    }

    @Override
    public int countArticleByUid(int uid) {
        return articleDao.countArticleByUid(uid);
    }

    @Override
    public Article findById(int id) {
        return articleDao.findById(id);
    }

    @Override
    public List<Article> findByUid(int uid) {
        return articleDao.findByUid(uid);
    }

    @Override
    public List<Article> findByTitle(String title) {
        return articleDao.findByTitle(title);
    }

    @Override
    public List<Article> findByCategoryName(String categoryName) {
        return articleDao.findByCategoryName(categoryName);
    }

    @Override
    public List<Article> findByCategoryId(int id) {
        return articleDao.findByCategory(id);
    }

    @Override
    public List<Article> findByStatus(int status) {
        return articleDao.findByStatus(status);
    }

    @Override
    public List<Article> userFindByCategoryName(String categoryName) {
        return articleDao.userFindByCategoryName(categoryName);
    }

    @Override
    public List<Article> userFindByTitle(String title) {
        return articleDao.userFindByTitle(title);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }
}
