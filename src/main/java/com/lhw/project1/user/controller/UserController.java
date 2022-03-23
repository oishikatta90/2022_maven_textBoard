package com.lhw.project1.user.controller;

import com.lhw.project1.user.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/usr")
public class UserController {
    int lastArticleId = 0;

    @RequestMapping("/article/doWrite")
    @ResponseBody
    public ResultData doWrite(String title, String body) {
        int id = lastArticleId += 1;
        String regDate = Util.getNowDateStr();
        String updateDate = Util.getNowDateStr();

        Article article = new Article(id, regDate, updateDate, title, body);

//
//        Map<String, Object> rsData = new HashMap<>();
//        rsData.put("resultCode", "S-1");
//        rsData.put("message", id + "번 글이 작성되었습니다.");
//        rsData.put("article", article);

        return new ResultData("S-1", id + "번글이 작성되었습니다.", article   );
    }
}

@Data
@AllArgsConstructor
class ResultData {
    private String resultData;
    private String msg;
    private Article article;
    }

@Data
@AllArgsConstructor
class Article {
    private int id;
    private String regDate;
    private String updateDate;
    private String title;
    private String body;
}
