package com.yzb.site.vo;

import com.yzb.site.entity.ArticleCategory;

public class CategoryVO {
    private Integer categoryId;
    private String categoryName;

    public CategoryVO() {
    }

    public CategoryVO(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public CategoryVO(ArticleCategory articleCategory){
        this.categoryId = articleCategory.getId();
        this.categoryName = articleCategory.getCategoryName();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryVO{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
