package com.lhw.project1.user.dao;

import com.lhw.project1.user.dto.Article;
import com.lhw.project1.user.service.ArticleService;
import com.lhw.project1.user.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleDao {
    private List<Article> articles;
    private int lastArticleId;

    public ArticleDao() {
        articles = new ArrayList<>();
        lastArticleId = 0;
        makeTestData();

    }

    //내부
    private void makeTestData() {
        for (int i = 0; i < 10; i++) {
            writeArticle("제목1", "내용1");
        }
    }


    public int writeArticle(String title, String body) {
        int id = lastArticleId + 1;
        String regDate = Util.getNowDateStr();
        String updateDate = Util.getNowDateStr();

        Article article = new Article(id, regDate, updateDate, title, body);
        articles.add(article);

        lastArticleId = id;

        return id;
    }

    public boolean modifyArticle(int id, String title, String body) {
        Article article = getArticleById(id);
        if (article == null) {
            return false;
        }
        article.setTitle(title);
        article.setBody(body);
        article.setUpdateDate(Util.getNowDateStr());
        return true;
    }

    public boolean deleteArticleById(int id) {
        Article article = getArticleById(id);

        if (article == null) {
            return false;
        }
        articles.remove(article);
        return true;
    }

    public Article getArticleById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }
}
