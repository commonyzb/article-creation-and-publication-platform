package com.yzb.site.entity;

public class RelationArticleCategory {
    private Integer id;
    private Integer aid;
    private Integer categoryId;

    public RelationArticleCategory() {
    }

    public RelationArticleCategory(Integer aid, Integer categoryId) {
        this.aid = aid;
        this.categoryId = categoryId;
    }

    public RelationArticleCategory(Integer id, Integer aid, Integer categoryId) {
        this.id = id;
        this.aid = aid;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
