package com.lhw.project1.user.service;

import com.lhw.project1.user.dao.ArticleDao;
import com.lhw.project1.user.dto.Article;
import com.lhw.project1.user.dto.ResultData;
import com.lhw.project1.user.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;


    public ArticleService() {

    }


    public Article getArticleById(int id) {
        Article article;
        return article = articleDao.getArticleById(id);
    }

    public ResultData writeArticle(String title, String body) {
        int id = articleDao.writeArticle(title, body);

        return new ResultData("S-1", id + "번 글이 작성되었습니다.");
    }

    public ResultData modifyArticle(Integer id, String title, String body) {
        Article article = getArticleById(id);

        if (article == null) {
            return new ResultData("F-4", "존재하지 않는 게시물 번호입니다.");
        }
        articleDao.modifyArticle(id, title, body);

        return new ResultData("S-1", "게시물이 수정되었습니다.","id", id);
    }

    public ResultData deleteArticleById(Integer id) {
        Article article = getArticleById(id);

        if (article == null) {
            return new ResultData("F-4", "존재하지 않는 게시물 번호입니다.");
        }
        articleDao.deleteArticleById(id);
        
        return new ResultData("S-1", id + "번 게시물이 삭제되었습니다.","id", id);
    }
}
