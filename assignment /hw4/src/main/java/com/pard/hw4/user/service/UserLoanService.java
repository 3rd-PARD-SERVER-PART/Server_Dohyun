package com.pard.hw4.user.service;

import com.pard.hw4.book.dto.BookDto;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.book.repo.BookRepo;
import com.pard.hw4.user.dto.UserDto;
import com.pard.hw4.user.dto.UserLoanDto;
import com.pard.hw4.user.entity.LoanBookHistory;
import com.pard.hw4.user.repo.UserLoanRepo;
import com.pard.hw4.user.repo.UserRepo;
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

    public List<UserLoanDto.Update> findAll(){
        return userLoanRepo.findAll()
                .stream()
                .map(loanBookHistory -> new UserLoanDto.Update(loanBookHistory,
                        new UserDto.Read(loanBookHistory.getUser()),
                        new BookDto.Read(loanBookHistory.getBook()))
                ).collect(Collectors.toList());
    }

    public String borrowBook(UserLoanDto.Create dto){
        if(checkedBookLoaning(dto)) {
            createLoan(dto);
            changeBookLoaning(dto, true);
            return "대출되었습니다.";
        }
        return "이미 누군가 빌려갔습니다.";
    }

    public void changeBookLoaning(UserLoanDto.Create dto, boolean loan){
        Book book = bookRepo.findById(dto.getBook().getBookId()).orElseThrow();
        book.change(loan);
        bookRepo.save(book);
    }
    public boolean checkedBookLoaning(UserLoanDto.Create dto){
        return !dto.getBook().isLoan();
    }

    public String returnBook(Long bookId){
        return "이미 반납된 책입니다.";
    }
}
