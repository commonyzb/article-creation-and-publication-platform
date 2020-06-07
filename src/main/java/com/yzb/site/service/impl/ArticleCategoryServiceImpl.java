package com.yzb.site.service.impl;

import com.yzb.site.dao.ArticleCategoryDao;
import com.yzb.site.entity.ArticleCategory;
import com.yzb.site.service.ArticleCategoryService;
import com.yzb.site.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;

    @Override
    public int addArticleCategory(ArticleCategory articleCategory) {
        return articleCategoryDao.addArticleCategory(articleCategory);
    }

    @Override
    public int deleteArticleCategory(ArticleCategory articleCategory) {
        return articleCategoryDao.deleteArticleCategory(articleCategory);
    }

    @Override
    public int deleteById(int id) {
        return articleCategoryDao.deleteById(id);
    }

    @Override
    public int updateArticleCategory(ArticleCategory articleCategory) {
        return articleCategoryDao.updateArticleCategory(articleCategory);
    }

    @Override
    public int countArticleCategory() {
        return articleCategoryDao.countCategory();
    }

    @Override
    public ArticleCategory findById(int id) {
        return articleCategoryDao.findById(id);
    }

    @Override
    public List<ArticleCategory> findByName(String name) {
        return articleCategoryDao.findByName(name);
    }

    @Override
    public List<ArticleCategory> findByAid(int aid) {
        return articleCategoryDao.findByAid(aid);
    }

    @Override
    public List<CategoryVO> categoryVOSFindByAid(int aid) {
        return articleCategoryDao.categoryVOSFindByAid(aid);
    }

    @Override
    public List<ArticleCategory> findAll() {
        return articleCategoryDao.findAll();
    }
}
