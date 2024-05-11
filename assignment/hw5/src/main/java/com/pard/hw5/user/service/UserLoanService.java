package com.pard.hw5.user.service;

import com.pard.hw5.book.dto.BookDto;
import com.pard.hw5.book.entity.Book;
import com.pard.hw5.book.repo.BookRepo;
import com.pard.hw5.user.dto.UserDto;
import com.pard.hw5.user.dto.UserLoanDto;
import com.pard.hw5.user.entity.LoanBookHistory;
import com.pard.hw5.user.repo.UserLoanRepo;
import com.pard.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserLoanService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    private final UserLoanRepo userLoanRepo;


    public void createLoan(UserLoanDto.Create dto){
                userLoanRepo.save(LoanBookHistory.toEntity(
                userRepo.findById(dto.getUser().getId()).orElseThrow(),
                bookRepo.findById(dto.getBook().getBookId()).orElseThrow()));
    }

    public UserLoanDto.Update checkLoanToBookNameAndUserName(String bookName, String userName){
        return (UserLoanDto.Update) userLoanRepo.findByUserAndBook(
                userRepo.findByName(userName),
                bookRepo.findByName(bookName));
    }
    public List<UserLoanDto.Update> findAll(){
        return userLoanRepo.findAll()
                .stream()
                .map(loanBookHistory -> new UserLoanDto.Update(loanBookHistory,
                        new UserDto.Read(loanBookHistory.getUser()),
                        new BookDto.Read(loanBookHistory.getBook()))
                ).collect(Collectors.toList());
    }

    public String borrowBook(UserLoanDto.Create dto){
        if(checkedBookLoan(dto)) {
            createLoan(dto);
            changeBookLoan(dto, true);
            return "대출되었습니다.";
        }
        return "이미 누군가 빌려갔습니다.";
    }

    public void changeBookLoan(UserLoanDto.Create dto, boolean loan){
        Book book = bookRepo.findById(dto.getBook().getBookId()).orElseThrow();
        book.change(loan);
        bookRepo.save(book);
    }
    public boolean checkedBookLoan(UserLoanDto.Create dto){
        return !dto.getBook().isLoan();
    }


    public boolean checkedBookLoan(Long loanBookId){
        return userLoanRepo.findById(loanBookId).orElseThrow().isLoan();
    }

    public void changeLoanHistory(Long loanBookId, boolean loan){
        LoanBookHistory loanBookHistory = userLoanRepo.findById(loanBookId).orElseThrow();
        loanBookHistory.change(loan);
        userLoanRepo.save(loanBookHistory);
    }

    public void changeBookLoan(Long loanBookId, boolean loan){
        long bookId = userLoanRepo.findById(loanBookId).orElseThrow().getId();
        Book book = bookRepo.findById(bookId).orElseThrow();
        book.change(loan);
        bookRepo.save(book);
    }
    public String returnBook(Long loanBookId){
        if(checkedBookLoan(loanBookId)){
            return "이미 반납된 책입니다.";
        }
        changeBookLoan(loanBookId, false);
        changeLoanHistory(loanBookId, true);
        return "반납되었습니다.";
    }
}
