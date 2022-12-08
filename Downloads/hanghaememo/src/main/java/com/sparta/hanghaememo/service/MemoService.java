package com.sparta.hanghaememo.service;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    //데이터베이스와 연결하는부분
    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {

        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Memo> getMemos() {

        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {

        //1.수정하려는 메모가 실제 레포지토리에 있는지 확인
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        //2.가저오는것이 생공했다면 가저온값을 변경
        memo.update(requestDto);    //dirty checking    @Transactional
        //https://jojoldu.tistory.com/415
        //memoRepository.save(memo);
        return memo.getId();


    }

    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;


    }
}
