package com.pard.fourthseminar.book.entity;

import com.pard.fourthseminar.book.dto.BookCreateDto;
import com.pard.fourthseminar.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //생성자 방식은 새로 만드는 것(create)만 가능하다.
    public Book(BookCreateDto dto, User user){
        this.name = dto.getName();
        this.user = user;
    }
}
