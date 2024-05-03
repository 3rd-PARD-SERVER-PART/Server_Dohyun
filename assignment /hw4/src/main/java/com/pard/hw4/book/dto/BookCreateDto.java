package com.pard.hw4.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateDto {
    private String name;
    private Long bookId;
    private Integer isLoan;
}
