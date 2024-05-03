package com.pard.hw4.book.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw4.book.entity.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookReadDto {
    private Long bookId;
    private String name;
    private Integer isLoan;
    //user 값을 넣기 위해 userDto를 가져옴.

    // do not loan book
    public BookReadDto(Book book){
        this.bookId = book.getBookId();
        this.name = book.getName();
        this.isLoan = book.getIsLoan();
    }
}
