package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Homework;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PostSelectDTO {

    private String title;
    private String username;
    private LocalDateTime createdAt;
    private String contents;


    public PostSelectDTO(Homework homework) {
        this.title = homework.getTitle();
        this.username = homework.getUsername();
        this.createdAt = homework.getCreatedAt();
        this.contents = homework.getContents();
    }


}
