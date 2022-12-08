package com.sparta.hanghaememo.controller;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MemoConrtoller {

    private final MemoService memoService;


    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }


    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
            return memoService.createMemo(requestDto);
    }

    @GetMapping("api/memos")
    public List<Memo> getMemos(){
        return memoService.getMemos();

    }

    @PutMapping("api/memos/{id}")
                        //id값으로 받아오고 memoRequestDto타입으로 반환하기 위해 둘다선언 수정할때 필요한 정보를 requestDto에 넣어서 받아옴
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        return memoService.update(id,requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        return memoService.deleteMemo(id);
    }


}
