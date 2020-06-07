package com.yzb.site.service;

import com.yzb.site.entity.RelationArticleCategory;

import java.util.List;

public interface RelationArticleCategoryService {
    /*
     * CRUD
     */
    int addRelation(RelationArticleCategory relationArticleCategory);

    int deleteRelation(RelationArticleCategory relationArticleCategory);

    int deleteRelationById(int id);

    int deleteRelationByAid(int aid);

    int deleteRelationByCategoryId(int categoryId);

    int upadteRelation(RelationArticleCategory relationArticleCategory);

    int updateRelation(int categoryId);

    RelationArticleCategory findById(int id);

    List<RelationArticleCategory> findByAid(int aid);

    List<RelationArticleCategory> findByCategoryId(int categoryId);

    List<RelationArticleCategory> findAll();
}
