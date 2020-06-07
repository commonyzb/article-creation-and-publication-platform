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

    /**
     * CRUD
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO article_category(category_name,description,update_time) VALUES(#{categoryName},#{description},#{updateTime});")
    int addArticleCategory(ArticleCategory articleCategory);

    @Delete("DELETE FROM article_category WHERE id=#{id};")
    int deleteArticleCategory(ArticleCategory articleCategory);

    @Delete("DELETE FROM article_category WHERE id=#{id};")
    int deleteById(int id);

    @Delete("DELETE FROM article_category WHERE category_name=#{categoryName};")
    int deleteByName(String categoryName);

    @Update("UPDATE article_category SET category_name=#{categoryName},description=#{description},update_time=#{updateTime} WHERE id=#{id};")
    int updateArticleCategory(ArticleCategory articleCategory);

    int countCategoryByUid();

    @Select("SELECT COUNT(*) FROM article_category;")
    int countCategory();

    @Select("SELECT DISTINCT c.* from article as a,article_category as c,relation_article_category as r WHERE #{aid}=r.aid AND c.id=r.category_id; ")
    List<ArticleCategory> findByAid(int aid);

    @Select("SELECT DISTINCT c.id,c.category_name from article as a,article_category as c,relation_article_category as r WHERE #{aid}=r.aid AND c.id=r.category_id;")
    List<CategoryVO> categoryVOSFindByAid(int aid);

    @Select("SELECT id,category_name,description,update_time FROM article_category WHERE id=#{id};")
    ArticleCategory findById(int id);

    @Select("SELECT id,category_name,description,update_time FROM article_category WHERE category_name LIKE CONCAT('%',#{categoryName},'%') ")
    List<ArticleCategory> findByName(String categoryName);

    @Select("SELECT id,category_name,description,update_time FROM article_category ")
    List<ArticleCategory> findAll();
}
