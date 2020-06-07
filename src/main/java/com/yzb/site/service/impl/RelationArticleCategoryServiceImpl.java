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
    public int addRelation(RelationArticleCategory relationArticleCategory) {
        return relationArticleCategoryDao.addRealtion(relationArticleCategory);
    }

    @Override
    public int deleteRelation(RelationArticleCategory relationArticleCategory) {
        return relationArticleCategoryDao.deleteRealtion(relationArticleCategory);
    }

    @Override
    public int deleteRelationById(int id) {
        return relationArticleCategoryDao.deleteById(id);
    }

    @Override
    public int deleteRelationByAid(int aid) {
        return relationArticleCategoryDao.deleteByAid(aid);
    }

    @Override
    public int deleteRelationByCategoryId(int categoryId) {
        return relationArticleCategoryDao.deleteByCategoryId(categoryId);
    }

    @Override
    public int upadteRelation(RelationArticleCategory relationArticleCategory) {
        return relationArticleCategoryDao.updateRealtion(relationArticleCategory);
    }

    @Override
    public int updateRelation(int categoryId) {
        return relationArticleCategoryDao.updateRelation(categoryId);
    }

    @Override
    public RelationArticleCategory findById(int id) {
        return relationArticleCategoryDao.findById(id);
    }

    @Override
    public List<RelationArticleCategory> findByAid(int aid) {
        return relationArticleCategoryDao.findByAid(aid);
    }

    @Override
    public List<RelationArticleCategory> findByCategoryId(int categoryId) {
        return relationArticleCategoryDao.findByCategoryId(categoryId);
    }

    @Override
    public List<RelationArticleCategory> findAll() {
        return relationArticleCategoryDao.findAll();
    }
}
