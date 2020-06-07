package com.yzb.site.service;

import com.yzb.site.entity.ArticleCategory;
import com.yzb.site.vo.CategoryVO;

import java.util.List;

public interface ArticleCategoryService {

    int addArticleCategory(ArticleCategory articleCategory);

    int deleteArticleCategory(ArticleCategory articleCategory);

    int deleteById(int id);

    int updateArticleCategory(ArticleCategory articleCategory);

    int countArticleCategory();

    ArticleCategory findById(int id);

    List<ArticleCategory> findByName(String name);

    List<ArticleCategory> findByAid(int aid);

    List<CategoryVO> categoryVOSFindByAid(int aid);

    List<ArticleCategory> findAll();
}
