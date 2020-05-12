package com.yzb.site.service;

import com.yzb.site.entity.ArticleCategory;
import com.yzb.site.vo.CategoryVO;

import java.util.List;

public interface ArticleCategoryService {

    Integer addArticleCategory(ArticleCategory articleCategory);

    Integer deleteArticleCategory(ArticleCategory articleCategory);

    Integer deleteById(Integer id);

    Integer updateArticleCategory(ArticleCategory articleCategory);

    Integer countArticleCategory();

    ArticleCategory findById(Integer id);

    List<ArticleCategory> findByName(String name);

    List<ArticleCategory> findByAid(Integer aid);

    List<CategoryVO> categoryVOSFindByAid(Integer aid);

    List<ArticleCategory> findAll();
}
