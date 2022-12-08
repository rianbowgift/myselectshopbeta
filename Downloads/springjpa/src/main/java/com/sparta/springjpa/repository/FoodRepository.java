package com.sparta.springjpa.repository;

import com.sparta.springjpa.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
    //jpa의 레퍼지토리를 상속받아서 어떤테이블과 연결할지 명시,id타입
}
