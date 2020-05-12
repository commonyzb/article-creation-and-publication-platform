package com.yzb.site.vo;

import java.util.Date;
import java.util.List;

public class NewArticleVO {
    private Integer aid;
    private String author;
    private String title;
    private List<Integer> categories;
    private String summary;
    private String content;
    private Integer likes;
    private Integer views;
    private Date createTime;
    private Integer enableComment;
    private Integer status;

    public NewArticleVO() {
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

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NewArticleVO{" +
                "aid=" + aid +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", categoryIds=" + categories +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", views=" + views +
                ", createTime=" + createTime +
                ", enableComment=" + enableComment +
                ", status=" + status +
                '}';
    }
}
