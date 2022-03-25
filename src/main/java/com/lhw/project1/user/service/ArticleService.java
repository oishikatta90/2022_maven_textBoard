package com.lhw.project1.user.service;

import com.lhw.project1.user.dao.ArticleDao;
import com.lhw.project1.user.dto.Article;
import com.lhw.project1.user.dto.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleDao articleDao;

    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public Article getArticleById(int id) {
        return articleDao.getArticleById(id);
    }

    public ResultData writeArticle(String title, String body) {
        int boardId = 3; // 가짜 데이터
        int memberId = 3; // 가짜 데이터
        articleDao.writeArticle(boardId, memberId, title, body);
        int id = articleDao.getLastInsertId();

        return new ResultData("S-1", id + "번 글이 작성되었습니다.");
    }

    public ResultData modifyArticle(Integer id, String title, String body) {
        Article article = getArticleById(id);

        if ( isEmpty(article)) {
            return new ResultData("F-4", "존재하지 않는 게시물 번호입니다.");
        }
        boolean sign = articleDao.modifyArticle(id, title, body);
        if (sign) {

            return new ResultData("S-1", "게시물이 수정되었습니다.", "id", id);
        } else {
            return new ResultData("F-1", "수정에 실패하셨습니다.");
        }
    }

    public ResultData deleteArticleById(Integer id) {
        Article article = getArticleById(id);

        if (isEmpty(article)) {
            return new ResultData("F-4", "존재하지 않는 게시물 번호입니다.");
        }
        articleDao.deleteArticleById(id);

        return new ResultData("S-1", id + "번 게시물이 삭제되었습니다.", "id", id);
    }

    private boolean isEmpty(Article article) {
        if (article == null) {
            return true;
        }
        else if (article.isDelStatus()) {
            return true;
        }
        return false;
    }
}
