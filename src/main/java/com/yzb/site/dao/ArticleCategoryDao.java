package com.yzb.site.dao;

import com.yzb.site.entity.ArticleCategory;
import com.yzb.site.vo.CategoryVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleCategoryDao {

    String TABLE_NAME = "article_category";
    String TABLE_COLUMN = "id,category_name,description,update_time";
    String ENTITY_FIELDS = "#{id},#{categoryName},#{description},#{updateTime}";

    /*
     * CRUD
     */

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO article_category(category_name,description,update_time) VALUES(#{categoryName},#{description},#{updateTime});")
    Integer addArticleCategory(ArticleCategory articleCategory);

    @Delete("DELETE FROM article_category WHERE id=#{id};")
    Integer deleteArticleCategory(ArticleCategory articleCategory);

    @Delete("DELETE FROM article_category WHERE id=#{id};")
    Integer deleteById(Integer id);

    @Delete("DELETE FROM article_category WHERE category_name=#{categoryName};")
    Integer deleteByName(String categoryName);

    @Update("UPDATE article_category SET category_name=#{categoryName},description=#{description},update_time=#{updateTime} WHERE id=#{id};")
    Integer updateArticleCategory(ArticleCategory articleCategory);

    Integer countCategoryByUid();

    @Select("SELECT COUNT(*) FROM article_category;")
    Integer countCategory();

    @Select("SELECT DISTINCT c.* from article as a,article_category as c,relation_article_category as r WHERE #{aid}=r.aid AND c.id=r.category_id; ")
    List<ArticleCategory> findByAid(Integer aid);

    @Select("SELECT DISTINCT c.id,c.category_name from article as a,article_category as c,relation_article_category as r WHERE #{aid}=r.aid AND c.id=r.category_id;")
    List<CategoryVO> categoryVOSFindByAid(Integer aid);

    @Select("SELECT id,category_name,description,update_time FROM article_category WHERE id=#{id};")
    ArticleCategory findById(Integer id);

    @Select("SELECT id,category_name,description,update_time FROM article_category WHERE category_name LIKE CONCAT('%',#{categoryName},'%') ")
    List<ArticleCategory> findByName(String categoryName);

    @Select("SELECT id,category_name,description,update_time FROM article_category ")
    List<ArticleCategory> findAll();
}
