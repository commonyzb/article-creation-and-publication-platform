package com.yzb.site.vo;

import com.yzb.site.entity.Article;

import java.util.Date;
import java.util.List;

public class ArticleVO {
    private Integer aid;
    private String author;
    private String title;
    private String summary;
    private String content;
    private Integer likes;
    private Integer views;
    private Date createTime;
    private Integer enableComment;
    private List<CategoryVO> categoryVOS;

    public ArticleVO() {
    }

    public ArticleVO(Article article){
        this.aid = article.getAid();
        this.author = article.getAuthor();
        this.title = article.getTitle();
        this.summary = article.getSummary();
        this.content = article.getContent();
        this.likes = article.getLikes();
        this.views = article.getViews();
        this.createTime = article.getCreateTime();
        this.enableComment = article.getEnableComment();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CategoryVO> getCategoryVOS() {
        return categoryVOS;
    }

    public void setCategoryVOS(List<CategoryVO> categoryVOS) {
        this.categoryVOS = categoryVOS;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Integer enableComment) {
        this.enableComment = enableComment;
    }
}
