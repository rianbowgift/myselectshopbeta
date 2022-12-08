package com.sparta.spa_spring_homework1.dto;

import com.sparta.spa_spring_homework1.entity.Homework;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostListDTO {

    private String username;
    private String contents;
    private LocalDateTime createdAt;



    public PostListDTO(Homework homework) {
        this.username = homework.getUsername();
        this.contents = homework.getContents();
        this.createdAt = homework.getCreatedAt();
    }



}
