package com.pard.hw4.book.entity;

import com.pard.hw4.book.dto.BookDto;
import com.pard.hw4.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String name;
    private Integer isLoan;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Book toEntity(BookDto.Create dto) {
        return Book.builder()
                .name(dto.getName())
                .isLoan(0)
                .build();
    }
    public void LoanBook(User user){
        this.isLoan = 1;
        this.user = user; // 빌림.
    }

    public void returnBook(User user){
        this.isLoan = 0 ; // 반납.
    }
}
