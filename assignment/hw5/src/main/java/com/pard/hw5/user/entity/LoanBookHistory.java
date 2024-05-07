package com.pard.hw5.user.entity;

import com.pard.hw5.book.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("false")
    private boolean loan;
    public static LoanBookHistory toEntity(User user, Book book){
        return LoanBookHistory.builder()
                .user(user)
                .book(book)
                .build();
    }

    public void change(boolean loan){
        this.loan = loan;
    }
}
