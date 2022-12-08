package com.sparta.hanghaememo.repository;


import com.sparta.hanghaememo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
    //findAllBy OrderBy ModifiedAtDesc
    //찾는다 전부  그런데 정렬을 최신순으로.(내림차순으로)
}