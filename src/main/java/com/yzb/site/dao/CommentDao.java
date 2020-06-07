package com.yzb.site.dao;

import com.yzb.site.entity.Article;
import com.yzb.site.entity.Comment;
import com.yzb.site.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {

    String TABLE_NAME = "comment";
    String TABLE_COLUMN = "id,aid,content,from_uid,to_uid,parent_id,create_time,status";
    String ENTITY_FIELDS = "#{id},#{aid},#{content},#{fromUid},#{toUid},#{parentId},#{createTime},#{status}";

    /*
     * CRUD
     */
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO comment(aid,content,from_uid,to_uid,parent_id,create_time,status) VALUES(#{aid},#{content},#{fromUid},#{toUid},#{parentId},#{createTime},#{status});")
    int addComment(Comment comment);

    @Delete("DElETE FROM comment WHERE id=#{id};")
    int deleteById(int id);

    @Delete("DELETE FROM comment WHERE id=#{id};")
    int deleteComment(Comment comment);

    @Delete("DELETE FROM comment WHERE aid={aid};")
    int deleteByAid(int aid);

    @Delete("DELETE FROM comment WHERE parent_id=#{parentId};")
    int deleteByParentId(int parentId);

    @Update("UPDATE comment SET aid=#{aid},content=#{content},uid=#{uid},parent_id=#{parentId},create_time=#{createTime},status=#{status} WHERE id=#{id};")
    int updateComment(Comment comment);

    @Update("UPDATE comment SET status=#{status} WHERE id=#{id} ")
    int updateCommentStatus(int id,int status);

    @Select("SELECT COUNT(*) FROM comment;")
    int countComment();

    @Select("SELECT COUNT(*) FROM comment WHERE from_uid=#{uid} ")
    int countCommentByUid(int uid);

    @Select("SELECT * FROM comment WHERE id=#{id} ")
    Comment findById(int id);

    @Select("SELECT * FROM comment WHERE id=#{id} ")
    Comment findByComment(Comment comment);

    @Select("SELECT * FROM comment WHERE uid=#{uid} ")
    List<Comment> findByUser(User user);

    @Select("SELECT * FROM comment WHERE from_uid=#{uid} ORDER BY create_time DESC ")
    List<Comment> findByFromUid(int uid);

    @Select("SELECT * FROM comment WHERE to_uid=#{uid} ORDER BY create_time DESC ")
    List<Comment> findByToUid(int uid);

    @Select("SELECT * FROM comment WHERE parent_id=#{parentId} ")
    List<Comment> findByParentId(int parentId);

    @Select("SELECT c.id,c.aid,c.from_uid,c.to_uid,c.content,c.create_time FROM comment AS c WHERE aid=#{aid} AND parent_id IS NULL ")
    List<Comment> findByFirstFloor(int aid);


    @Select("SELECT * FROM comment WHERE aid=#{aid} ORDER BY create_time DESC")
    List<Comment> findByAid(int aid);

    @Select("SELECT * FROM comment WHERE aid=#{aid}")
    List<Comment> findByArticle(Article article);

    @Select("SELECT * FROM comment WHERE status=#{status} ")
    List<Comment> findByStatus(int status);

    @Select("SELECT * FROM comment ")
    List<Comment> findAll();

}
