package com.yzb.site.service.impl;

import com.yzb.site.dao.RelationArticleCategoryDao;
import com.yzb.site.entity.RelationArticleCategory;
import com.yzb.site.service.RelationArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationArticleCategoryServiceImpl implements RelationArticleCategoryService {

    @Autowired
    private RelationArticleCategoryDao relationArticleCategoryDao;

    @Override
    public Integer addRelation(RelationArticleCategory relationArticleCategory) {
        return relationArticleCategoryDao.addRealtion(relationArticleCategory);
    }

    @Override
    public Integer deleteRelation(RelationArticleCategory relationArticleCategory) {
        return relationArticleCategoryDao.deleteRealtion(relationArticleCategory);
    }

    @Override
    public Integer deleteRelationById(Integer id) {
        return relationArticleCategoryDao.deleteById(id);
    }

    @Override
    public Integer deleteRelationByAid(Integer aid) {
        return relationArticleCategoryDao.deleteByAid(aid);
    }

    @Override
    public Integer deleteRelationByCategoryId(Integer categoryId) {
        return relationArticleCategoryDao.deleteByCategoryId(categoryId);
    }

    @Override
    public Integer upadteRelation(RelationArticleCategory relationArticleCategory) {
        return relationArticleCategoryDao.updateRealtion(relationArticleCategory);
    }

    @Override
    public Integer updateRelation(Integer categoryId) {
        return relationArticleCategoryDao.updateRelation(categoryId);
    }

    @Override
    public RelationArticleCategory findById(Integer id) {
        return relationArticleCategoryDao.findById(id);
    }

    @Override
    public List<RelationArticleCategory> findByAid(Integer aid) {
        return relationArticleCategoryDao.findByAid(aid);
    }

    @Override
    public List<RelationArticleCategory> findByCategoryId(Integer categoryId) {
        return relationArticleCategoryDao.findByCategoryId(categoryId);
    }

    @Override
    public List<RelationArticleCategory> findAll() {
        return relationArticleCategoryDao.findAll();
    }
}
