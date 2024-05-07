package com.pard.hw4.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw4.book.dto.BookDto;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.user.entity.LoanBookHistory;
import com.pard.hw4.user.entity.User;
import lombok.Getter;
import lombok.Setter;


public class UserLoanDto {

    @Setter
    @Getter
    public static class Create{
        private Long id;
        private Book book;
        private User user;
        private boolean isLoan;
    }

    @Setter
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Update{
        private Long id;
        private BookDto.Read book;
        private UserDto.Read user;
        private boolean isLoan;

        public Update(LoanBookHistory loanBookHistory, UserDto.Read user, BookDto.Read book){
            this.id = loanBookHistory.getId();
            this.isLoan = loanBookHistory.isLoan();
            this.book = book;
            this.user = user;
        }
    }
}
