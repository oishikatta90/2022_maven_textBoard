package com.lhw.project1.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private int id;
    private String regDate;
    private String updateDate;
    private int boardId;
    private int memberId;
    private String title;
    private String body;
    private boolean blindStatus;
    private String blindDate;
    private boolean delStatus;
    private String delDate;
    private int hitCount;
    private int repliesCount;
    private int likeCount;
    private int dislikeCount;

}