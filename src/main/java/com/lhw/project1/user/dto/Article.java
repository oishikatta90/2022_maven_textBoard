package com.lhw.project1.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private int id;
    private String regDate;
    private String updateDate;
    private String title;
    private String body;
}