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
        makeTestData();
    }

    @RequestMapping("/article/doWrite")
    @ResponseBody
    public ResultData doWrite(String title, String body) {
        if (Util.isEmpty(title)) {
            return new ResultData("F-1", "제목을 입력해주세요.");
        }
        if (Util.isEmpty(body)) {
            return new ResultData("F-2", "내용을 입력해주세요.");
        }
        int id = writeArticle(title, body);
        Article article = getArticleById(id);
        return new ResultData("S-1", article.getId() + "번글이 작성되었습니다.", "article", article, "articleTitle", article.getTitle(), "regDate", article.getRegDate());
    }

    @RequestMapping("/article/doModify")
    @ResponseBody
    public ResultData doModify(Integer id, String title, String body) {
        if (Util.isEmpty(id)) {
            return new ResultData("F-0", "바꾸실 글 번호를 입력해주세요.");
        }
        if (Util.isEmpty(title)) {
            return new ResultData("F-1", "제목을 입력해주세요.");
        }
        if (Util.isEmpty(body)) {
            return new ResultData("F-2", "내용을 입력해주세요.");
        }
        modifyArticle(id, title, body);
        return new ResultData("S-1", id + "번 글이 변경되었습니다.", "내용",getArticleById(id));
    }

    @RequestMapping("/article/getArticle")
    @ResponseBody
    public ResultData getArticle(Integer id) {
        if (Util.isEmpty(id)) {
            return new ResultData("F-0", "글 번호를 입력해주세요.");
        }
        Article article = getArticleById(id);
        if (article == null) {
            return new ResultData("F-1", "존재하지 않는 게시물입니다!");
        }
        return new ResultData("S-1", article.getId() + "번 글을 찾았습니다.", "article", article);
    }

    @RequestMapping("/article/doDelete")
    @ResponseBody
    public ResultData doDelete(Integer id) {
        if (Util.isEmpty(id)) {
            return new ResultData("F-0", "지우실 번호를 입력해주세요.");
        }
        boolean deleted = deleteArticleById(id);

        if (deleted == false) {
            return new ResultData("F-1", id + "번 글이 존재하지 않습니다.", "id", id);
        }

        return new ResultData("S-1", id + "번 글이 삭제되었습니다.", "id", id);


    }

    //내부
    private boolean modifyArticle(int id, String title, String body) {
        Article article = getArticleById(id);
        if (article == null) {
            return false;
        }
        article.setTitle(title);
        article.setBody(body);
        article.setUpdateDate(Util.getNowDateStr());
        return true;
    }

    private void makeTestData() {
        for (int i = 0; i < 10; i++) {
            writeArticle("제목1", "내용1");
        }
    }


    private boolean deleteArticleById(int id) {
        Article article = getArticleById(id);

        if (article == null) {
            return false;
        }
        articles.remove(article);
        return true;
    }

    private Article getArticleById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    private int writeArticle(String title, String body) {
        int id = lastArticleId + 1;
        String regDate = Util.getNowDateStr();
        String updateDate = Util.getNowDateStr();

        Article article = new Article(id, regDate, updateDate, title, body);
        articles.add(article);

        lastArticleId = id;

        return id;
    }
}



