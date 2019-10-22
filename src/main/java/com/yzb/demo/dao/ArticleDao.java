package com.yzb.demo.dao;

import com.yzb.demo.entity.Article;
import com.yzb.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {

    final String TABLE_NAME = "article";
    final String TABLE_COLUMN = "aid,author,title,content,label,create_time,likes,uid,status";
    final String UPDATE_COLUMN = "#{author},#{title},#{content},#{label},#{createTime},#{likes},#{uid},#{status}";
    /*
     * CRUD
     */

    @Options(useGeneratedKeys = true,keyProperty = "aid",keyColumn = "aid")
    @Insert("INSERT INTO article(aid,author,title,content,label,create_time,likes,uid,status) VALUES();")
    Integer addArticle(Article article);

    @Delete("DELETE FROM article WHERE aid=#{aid};")
    Integer deleteArticle(Article article);

    @Update("UPDATE article(author,title,content,label,create_time,likes,uid,status) SET(#{author},#{title},#{content},#{label},#{createTime},#{likes},#{uid},#{status}) WHERE aid=#{aid};")
    Integer updateArticle(Article article);

    @Select("SELECT * FROM article WHERE aid=#{id};")
    Article findById(Integer id);

    @Select("SELECT * FROM article WHERE uid=#{uid};")
    List<Article> findByUser(User user);

    @Select("SELECT * FROM article WHERE title LIKE '%'#{title}'%';")
    List<Article> findByTitle(String title);

    @Select("SELECT * FROM article WHERE ")
    List<Article> findByType(String type);



    @Select("SELECT * FROM article WHERE status=#{status};")
    List<Article> findByStatus(String status);
}
