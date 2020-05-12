package com.yzb.site.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ArticleCategory {
    private Integer id;
    private String categoryName;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public ArticleCategory() {
    }

    public ArticleCategory(String categoryName, String description, Date updateTime) {
        this.categoryName = categoryName;
        this.description = description;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ArticleCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
