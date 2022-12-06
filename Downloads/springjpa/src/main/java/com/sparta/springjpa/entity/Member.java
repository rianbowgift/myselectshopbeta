package com.sparta.springjpa.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
public class Member {   //User 라는 이름은 h2에서 내부지정값이라 반드시 피해야한다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)   //널이 아니도록
    private String memberName;


    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER)
    private List<Orders> orders = new ArrayList<>();

    public Member(String memberName) {
        this.memberName = memberName;
    }
}
