package com.yzb.site.service;

import com.yzb.site.entity.RelationArticleCategory;

import java.util.List;

public interface RelationArticleCategoryService {
    /*
     * CRUD
     */
    Integer addRelation(RelationArticleCategory relationArticleCategory);

    Integer deleteRelation(RelationArticleCategory relationArticleCategory);

    Integer deleteRelationById(Integer id);

    Integer deleteRelationByAid(Integer aid);

    Integer deleteRelationByCategoryId(Integer categoryId);

    Integer upadteRelation(RelationArticleCategory relationArticleCategory);

    Integer updateRelation(Integer categoryId);

    RelationArticleCategory findById(Integer id);

    List<RelationArticleCategory> findByAid(Integer aid);

    List<RelationArticleCategory> findByCategoryId(Integer categoryId);

    List<RelationArticleCategory> findAll();
}
