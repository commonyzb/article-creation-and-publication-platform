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
    Integer addComment(Comment comment);

    @Delete("DElETE FROM comment WHERE id=#{id};")
    Integer deleteById(Integer id);

    @Delete("DELETE FROM comment WHERE id=#{id};")
    Integer deleteComment(Comment comment);

    @Delete("DELETE FROM comment WHERE aid={aid};")
    Integer deleteByAid(Integer aid);

    @Delete("DELETE FROM comment WHERE parent_id=#{parentId};")
    Integer deleteByParentId(Integer parentId);

    @Update("UPDATE comment SET aid=#{aid},content=#{content},uid=#{uid},parent_id=#{parentId},create_time=#{createTime},status=#{status} WHERE id=#{id};")
    Integer updateComment(Comment comment);

    @Update("UPDATE comment SET status=#{status} WHERE id=#{id} ")
    Integer updateCommentStatus(Integer id,Integer status);

    @Select("SELECT COUNT(*) FROM comment;")
    Integer countComment();

    @Select("SELECT COUNT(*) FROM comment WHERE from_uid=#{uid} ")
    Integer countCommentByUid(Integer uid);

    @Select("SELECT * FROM comment WHERE id=#{id} ")
    Comment findById(Integer id);

    @Select("SELECT * FROM comment WHERE id=#{id} ")
    Comment findByComment(Comment comment);

    @Select("SELECT * FROM comment WHERE uid=#{uid} ")
    List<Comment> findByUser(User user);

    @Select("SELECT * FROM comment WHERE from_uid=#{uid} ORDER BY create_time DESC ")
    List<Comment> findByFromUid(Integer uid);

    @Select("SELECT * FROM comment WHERE to_uid=#{uid} ORDER BY create_time DESC ")
    List<Comment> findByToUid(Integer uid);

    @Select("SELECT * FROM comment WHERE parent_id=#{parentId} ")
    List<Comment> findByParentId(Integer parentId);

    @Select("SELECT c.id,c.aid,c.from_uid,c.to_uid,c.content,c.create_time FROM comment AS c WHERE aid=#{aid} AND parent_id IS NULL ")
    List<Comment> findByFirstFloor(Integer aid);


    @Select("SELECT * FROM comment WHERE aid=#{aid} ORDER BY create_time DESC")
    List<Comment> findByAid(Integer aid);

    @Select("SELECT * FROM comment WHERE aid=#{aid}")
    List<Comment> findByArticle(Article article);

    @Select("SELECT * FROM comment WHERE status=#{status} ")
    List<Comment> findByStatus(Integer status);

    @Select("SELECT * FROM comment ")
    List<Comment> findAll();

}
