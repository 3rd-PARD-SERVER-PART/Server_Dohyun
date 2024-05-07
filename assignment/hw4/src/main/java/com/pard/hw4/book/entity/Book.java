package com.pard.hw4.book.entity;

import com.pard.hw4.book.dto.BookDto;
import com.pard.hw4.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("0")
    private boolean isLoan;

    public static Book toEntity(BookDto.Create dto) {
        return Book.builder()
                .name(dto.getName())
                .isLoan(false)
                .build();
    }

    public void change(boolean loan){
        this.isLoan = loan;
    }

}