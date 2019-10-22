package com.yzb.demo.entity;

import java.util.Date;

public class Comment {
    private Integer id;
    private Integer aid;
    private String content;
    private Integer uid;
    private Integer parentId;
    private Date createDate;

    public Comment() {
    }

    public Comment(Integer id, Integer aid, String content, Integer uid, Integer parentId, Date createDate) {
        this.id = id;
        this.aid = aid;
        this.content = content;
        this.uid = uid;
        this.parentId = parentId;
        this.createDate = createDate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", aid=" + aid +
                ", content='" + content + '\'' +
                ", uid=" + uid +
                ", parentId=" + parentId +
                ", createDate=" + createDate +
                '}';
    }
}
