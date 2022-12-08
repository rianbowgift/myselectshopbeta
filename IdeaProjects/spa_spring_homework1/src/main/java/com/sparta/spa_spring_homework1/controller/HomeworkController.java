package com.sparta.spa_spring_homework1.controller;

import com.sparta.spa_spring_homework1.dto.PostEditDTO;
import com.sparta.spa_spring_homework1.dto.PostListDTO;
import com.sparta.spa_spring_homework1.dto.PostSelectDTO;
import com.sparta.spa_spring_homework1.entity.Homework;
import com.sparta.spa_spring_homework1.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class HomeworkController {


    private final HomeworkService homeworkService;


    @GetMapping("/api/allList")
    public List<PostListDTO> getList(){
        return homeworkService.getList();
    }


    @PostMapping("/api/addPost/{title}/{username}/{password}/{contents}")
    public Homework addPost(@PathVariable String title,@PathVariable String username,@PathVariable String password,@PathVariable String contents){
        return homeworkService.addPost(title,username,password,contents);
    }

    @GetMapping("/api/viewPost/{id}")
    public PostSelectDTO viewPost(@PathVariable Long id){
        return homeworkService.viewPost(id);
    }

    @PutMapping("/api/editPost/{id}/{contents}/{password}")
    public PostEditDTO editPost(@PathVariable Long id,@PathVariable String contents,@PathVariable String password){

        return homeworkService.editPost(id,contents,password);
    }

    @DeleteMapping("/api/deletePost/{id}/{password}")
    public String deletePost(@PathVariable Long id,@PathVariable String password){
        return homeworkService.deletePost(id,password);
    }






}











//테스트코드
//1.사용자 생성 세명 POST
//http://localhost:8080/api/addPost/himans/song/1234/goodman
//http://localhost:8080/api/addPost/higirl/kim/5678/goodgirl
//http://localhost:8080/api/addPost/안녕하세요/park/9999/반가워요

//2.전체 글 검색 GET
//http://localhost:8080/api/allList


//3.특정 글 검색 GET
//http://localhost:8080/api/viewPost/2


//4.글수정 실패  PUT
//http://localhost:8080/api/editPost/1/수정된글/12345

//5.글수정 성공 PUT
//http://localhost:8080/api/editPost/1/수정된글/1234

//6.글삭제 실패 DELETE
//http://localhost:8080/api/deletePost/1/12345

//7.글삭제 성공 DELETE
//http://localhost:8080/api/deletePost/1/1234
