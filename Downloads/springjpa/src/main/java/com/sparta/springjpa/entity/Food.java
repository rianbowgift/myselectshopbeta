package com.sparta.springjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String foodName;
    @Column(nullable = false)
    private String price;


                                //오더 클래스와의 join에서
    @OneToMany(mappedBy = "food", fetch = FetchType.EAGER)//연관관계의 주인을 지정한다. 조인했을때 주인이 누군지 명시
    private List<Orders> orders = new ArrayList<>();

    public Food(String foodName, String price) {
        this.foodName = foodName;
        this.price = price;
    }
}
