package com.lhw.project1.user.controller;

import com.lhw.project1.user.dto.Article;
import com.lhw.project1.user.dto.ResultData;
import com.lhw.project1.user.service.ArticleService;
import com.lhw.project1.user.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
//        this.articleService = new ArticleService();
    }

    @RequestMapping("/project1/article/doWrite")
    @ResponseBody
    public ResultData doWrite(String title, String body) {
        if (Util.isEmpty(title)) {
            return new ResultData("F-1", "제목을 입력해주세요.");
        }
        if (Util.isEmpty(body)) {
            return new ResultData("F-2", "내용을 입력해주세요.");
        }
        return articleService.writeArticle(title, body);
    }

    @RequestMapping("/project1/article/doModify")
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
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return new ResultData("F-4", "존재하지 않는 게시물 번호입니다.");
        }

        return articleService.modifyArticle(id, title, body);
    }

    @RequestMapping("/project1/article/doDelete")
    @ResponseBody
    public ResultData doDelete(Integer id) {
        if (Util.isEmpty(id)) {
            return new ResultData("F-0", "지우실 번호를 입력해주세요.");
        }
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return new ResultData("F-4", "존재하지 않는 게시물 번호입니다.");
        }
        return articleService.deleteArticleById(id);
    }

    @RequestMapping("/project1/article/list")
    public String showList() {
        return "project1/article/list";
    }

    @RequestMapping("/project1/article/getArticle")
    @ResponseBody
    public ResultData getArticle(Integer id) {
        if (Util.isEmpty(id)) {
            return new ResultData("F-0", "글 번호를 입력해주세요.");
        }
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return new ResultData("F-1", "존재하지 않는 게시물입니다!");
        }
        return new ResultData("S-1", article.getId() + "번 글을 찾았습니다.", "article", article);
    }


}



