package com.lhw.project1.user.dao;

import com.lhw.project1.user.dto.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleDao {
    void writeArticle(@Param("boardId") int boardId, @Param("memberId") int memberId, @Param("title") String title, @Param("body") String body);

    boolean modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);

    void deleteArticleById(@Param("id") int id);

    Article getArticleById(@Param("id") int id);
    }
