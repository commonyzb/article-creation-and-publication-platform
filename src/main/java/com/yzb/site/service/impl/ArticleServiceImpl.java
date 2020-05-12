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
    public Integer addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public Integer deleteArticle(Article article) {
        return articleDao.deleteArticle(article);
    }

    @Override
    public Integer deleteArticle(Integer id) {
        return articleDao.deleteById(id);
    }

    @Override
    public Integer updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public Integer updateArticleStatus(Integer aid, Integer status) {
        return articleDao.updateArticleStatus(aid,status);
    }

    @Override
    public Integer updateEnableCommentStatus(Integer aid, Integer enableComment) {
        return articleDao.updateEnableComment(aid,enableComment);
    }

    @Override
    public Integer updateAuditStatus(Integer aid, Integer auditStatus) {
        return articleDao.updateAuditStatus(aid,auditStatus);
    }

    @Override
    public Integer countArticle() {
        return articleDao.countArticle();
    }

    @Override
    public Integer countArticleByUid(Integer uid) {
        return articleDao.countArticleByUid(uid);
    }

    @Override
    public Article findById(Integer id) {
        return articleDao.findById(id);
    }

    @Override
    public List<Article> findByUid(Integer uid) {
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
    public List<Article> findByCategoryId(Integer id) {
        return articleDao.findByCategory(id);
    }

    @Override
    public List<Article> findByStatus(Integer status) {
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
