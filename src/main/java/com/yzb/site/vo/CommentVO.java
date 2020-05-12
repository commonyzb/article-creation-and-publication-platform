package com.yzb.site.vo;

import com.yzb.site.entity.Comment;

import java.util.Date;
import java.util.List;

public class CommentVO {
    private Integer id;
    private Integer aid;
    private Integer fromUid;
    private String fromUserName;
    private Integer toUid;
    private String toUserName;
    private String content;
    private Date createTime;
    private List<CommentVO> replys;

    public CommentVO() {
    }

    public CommentVO(Comment comment){
        this.id = comment.getId();
        this.aid = comment.getAid();
        this.fromUid = comment.getFromUid();
        this.toUid  =comment.getToUid();
        this.content = comment.getContent();
        this.createTime = comment.getCreateTime();
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

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<CommentVO> getReplys() {
        return replys;
    }

    public void setReplys(List<CommentVO> replys) {
        this.replys = replys;
    }
}
