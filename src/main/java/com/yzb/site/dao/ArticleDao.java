package com.yzb.site.dao;

import com.yzb.site.entity.Article;
import com.yzb.site.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleDao {

    final String TABLE_NAME = "article";
    final String TABLE_COLUMN = "aid,author,title,content,summary,create_time,likes,views,uid,status,enable_comment,audit_status";
    final String UPDATE_COLUMN = "#{author},#{title},#{content},#{summary},#{createTime},#{likes},#{views},#{uid},#{status},#{enableComment},#{auditStatus}";
    /*
     * CRUD
     */

    @Options(useGeneratedKeys = true,keyProperty = "aid",keyColumn = "aid")
    @Insert("INSERT INTO article(author,title,content,summary,create_time,likes,views,uid,status,enable_comment,audit_status) VALUES(#{author},#{title},#{content},#{summary},#{createTime},#{likes},#{views},#{uid},#{status},#{enableComment},#{auditStatus}) " )
    int addArticle(Article article);

    @Delete("DELETE FROM article WHERE aid=#{aid}")
    int deleteArticle(Article article);

    @Delete("DELETE FROM article WHERE aid=#{aid}")
    int deleteById(int id);

    @Update("UPDATE article SET author=#{author},title=#{title},content=#{content},summary=#{summary},create_time=#{createTime},likes=#{likes},views=#{views},uid=#{uid},status=#{status},enable_comment=#{enableComment},audit_status=#{auditStatus} WHERE aid=#{aid};")
    int updateArticle(Article article);

    @Update("UPDATE article SET enable_comment=#{enableComment} WHERE aid=#{aid} ")
    int updateEnableComment(int aid,int enableComment);

    @Update("UPDATE article SET status=#{status} WHERE aid=#{aid} ")
    int updateArticleStatus(int aid,int status);

    @Update("UPDATE article SET audit_status=#{auditStatus} WHERE aid=#{aid} ")
    int updateAuditStatus(int aid,int auditStatus);

    @Select("SELECT COUNT(*) FROM article;")
    int countArticle();

    @Select("SELECT COUNT(*) FROM article WHERE article.uid=#{uid};")
    int countArticleByUid(int uid);

    @Select("SELECT * FROM article WHERE aid=#{id} ")
    Article findById(int id);

    @Select("SELECT * FROM article WHERE uid=#{uid} ")
    List<Article> findByUid(int uid);

    @Select("SELECT * FROM article WHERE uid=#{uid} ")
    List<Article> findByUser(User user);

    @Select("SELECT article.* FROM article WHERE author=#{userName}")
    List<Article> findByUserName(String userName);

//    @Select("SELECT DISTINCT a.* FROM article as a,article_category as c,relation_article_category as r WHERE a.aid=r.aid AND r.category_id=#{categoryId} ;")
    @Select("SELECT DISTINCT a.* FROM relation_article_category as r INNER JOIN article_category as c ON #{categoryId}=c.id LEFT JOIN article as a ON a.aid=r.aid ")
    List<Article> findByCategory(int categoryId);

    @Select("SELECT a.* FROM article as a,article_category as c,relation_article_category as r WHERE a.aid=r.aid AND r.category_id=c.id AND category_name=#{categoryName} ")
    List<Article> findByCategoryName(String categoryName);

    @Select("SELECT * FROM article WHERE title LIKE CONCAT('%',#{title},'%') ")
    List<Article> findByTitle(String title);

    @Select("SELECT * FROM article WHERE summary=#{summary} ")
    List<Article> findBysummary(String summary);

    @Select("SELECT * FROM article WHERE status=#{status} ")
    List<Article> findByStatus(int status);

    @Select("select a.* from article as a inner join relation_article_category as r on a.aid=r.aid and a.status=1 and a.audit_status=1 inner join article_category as c on r.category_id=c.id where c.category_name=#{categoryName}; ")
    List<Article> userFindByCategoryName(String categoryName);

    @Select("SELECT * FROM article WHERE title LIKE CONCAT('%',#{title},'%') AND status=1 AND audit_status=1 ")
    List<Article> userFindByTitle(String title);

    @Select("SELECT * FROM article ")
    List<Article> findAll();
}
