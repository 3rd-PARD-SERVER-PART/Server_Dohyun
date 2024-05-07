package com.pard.hw5.book.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw5.book.entity.Book;
import lombok.Getter;
import lombok.Setter;

public class BookDto {

    @Getter
    @Setter
    public static class Create {
        private String name;
        private Long bookId;
        private boolean isLoan;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read {
        private Long bookId;
        private String name;
        private boolean isLoan;

        // do not loan book
        public Read(Book book){
            this.bookId = book.getBookId();
            this.name = book.getName();
            this.isLoan = book.isLoan();
        }
    }
}
