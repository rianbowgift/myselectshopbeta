package com.sparta.spa_spring_homework1.repository;

import com.sparta.spa_spring_homework1.dto.PostListDTO;
import com.sparta.spa_spring_homework1.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework,Long> {

}
