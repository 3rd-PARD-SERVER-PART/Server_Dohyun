package com.pard.hw5.user.entity;

import com.pard.hw5.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
// setter 를 넣어 줌으로써 데이터베이스 상 정보 관리 가능.
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanBookHistory> userLoanHistories = new ArrayList<>();

    // method 방식은 update가 가능하다.
    public static User toEntity(UserDto.Create dto){
        return User.builder()
                .name(dto.getName())
                .build();
    }

    public User update(String name){
        this.name = name;
        return this;
    }
}
