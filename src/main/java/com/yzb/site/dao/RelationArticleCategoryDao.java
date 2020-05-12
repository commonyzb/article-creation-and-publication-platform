package com.yzb.site.dao;

import com.yzb.site.entity.RelationArticleCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RelationArticleCategoryDao {

    String TABLE_NAME = "relation_article_category";
    String TABLE_COLUMN = "id,aid,category_id";
    String ENTITY_FIELDS = "#{id},#{aid},#{categoryId}";

    /*
     * CRUD
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO relation_article_category(aid,category_id) VALUES(#{aid},#{categoryId}) ")
    Integer addRealtion(RelationArticleCategory relationArticleCategory);

    @Delete("DELETE FROM relation_article_category WHERE id=#{id};")
    Integer deleteById(Integer id);

    @Delete("DELETE FROM relation_article_category WHERE category_id=#{categroyId};")
    Integer deleteByCategoryId(Integer categoryId);

    @Delete("DELETE FROM relation_article_category WHERE aid=#{aid};")
    Integer deleteByAid(Integer aid);

    @Delete("DELETE FROM relation_article_category WHERE aid=#{aid} AND category_id=#{categoryId};")
    Integer deleteRealtion(RelationArticleCategory relationArticleCategory);

    @Update("UPDATE relation_article_category SET aid=#{aid},category_id=#{categoryId} WHERE id=#{id};")
    Integer updateRealtion(RelationArticleCategory relationArticleCategory);

    @Update("UPDATE relation_article_category set category_id=3 WHERE category_id=#{categoryId};")
    Integer updateRelation(Integer categoryId);

    @Select("SELECT * FROM relation_article_category WHERE aid=#{aid} AND category_id=#{categoryId};")
    RelationArticleCategory findByRelationArticleCategory(RelationArticleCategory relationArticleCategory);

    @Select("SELECT * FROM relation_article_category WHERE category_id=#{categoryId};")
    List<RelationArticleCategory> findByCategoryId(Integer categoryId);

    @Select("SELECT * FROM relation_article_category WHERE aid=#{aid};")
    List<RelationArticleCategory> findByAid(Integer aid);

    @Select("SELECT * FROM relation_article_category WHERE id=#{id};")
    RelationArticleCategory findById(Integer id);

    @Select("SELECT * FROM relation_article_category ")
    List<RelationArticleCategory> findAll();

}
