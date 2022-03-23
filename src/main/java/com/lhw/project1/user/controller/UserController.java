package com.lhw.project1.user.controller;

import com.lhw.project1.user.dto.Article;
import com.lhw.project1.user.dto.ResultData;
import com.lhw.project1.user.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usr")
public class UserController {
    private List<Article> articles;
    int lastArticleId;

    public UserController() {
        articles = new ArrayList<>();
        lastArticleId = 0;
    }

    @RequestMapping("/article/doWrite")
    @ResponseBody
    public ResultData doWrite(String title, String body) {
        Article article = writeArticle(title, body);
        return new ResultData("S-1", article.getId() + "번글이 작성되었습니다.", "article", article, "articleTitle", article.getTitle(), "regDate", article.getRegDate());
    }

    private Article writeArticle(String title, String body) {
        int id = lastArticleId + 1;
        String regDate = Util.getNowDateStr();
        String updateDate = Util.getNowDateStr();

        Article article = new Article(id, regDate, updateDate, title, body);
        articles.add(article);

        lastArticleId = id;

        return article;
    }

    @RequestMapping("/article/getArticle")
    @ResponseBody
    public ResultData getArticle(int id) {
        Article article = getArticleById(id);
        if (article == null) {
            return new ResultData("F-1", "존재하지 않는 게시물입니다!");
        }
        return new ResultData("S-1", article.getId() + "번 글을 찾았습니다.", "article", article);
    }

    private Article getArticleById(int id) {
        for (Article article : articles){
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }
}



