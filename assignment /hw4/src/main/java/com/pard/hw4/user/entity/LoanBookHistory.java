package com.pard.hw4.user.entity;

import com.pard.hw4.book.entity.Book;
import com.pard.hw4.user.dto.UserLoanDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanBookHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer isLoan;

    public LoanBookHistory toEntity(UserLoanDto.Create dto, Book book, User user){
        return LoanBookHistory.builder()
                .user(user)
                .book(book)
                .isLoan(getIsLoan())
                .build();
    }
}
