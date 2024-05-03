package com.pard.hw4.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw4.book.dto.BookReadDto;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.user.entity.LoanBookHistory;
import com.pard.hw4.user.entity.User;
import lombok.Getter;
import lombok.Setter;


public class UserLoanDto {
    @Setter
    @Getter
    public static class Create{
        private Book book;
        private Integer isLoan = 1;
        private User user;
    }

    @Setter
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Update{
        private Integer isLoan;
        private BookReadDto book;
        private UserDto.Read user;

        public Update(LoanBookHistory loanBookHistory){
            this.isLoan = loanBookHistory.getIsLoan();
        }
        public Update(LoanBookHistory loanBookHistory, UserDto.Read user){
            this.isLoan = loanBookHistory.getIsLoan();
            this.user = user;
        }
        public Update(LoanBookHistory loanBookHistory, UserDto.Read user, BookReadDto book){
            this.isLoan = loanBookHistory.getIsLoan();
            this.book = book;
            this.user = user;
        }
    }
}
