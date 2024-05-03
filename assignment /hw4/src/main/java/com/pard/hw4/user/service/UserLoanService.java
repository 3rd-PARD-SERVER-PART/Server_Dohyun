package com.pard.hw4.user.service;

import com.pard.hw4.book.repo.BookRepo;
import com.pard.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserLoanService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

//    public String loanById(Long bookId, Long userId){
//        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));;
//        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Book not found with id: " + userId));

//        if(book.getIsLoan() == 1){
//            return "자리에 없습니다.";
//        }
//        else{
//            book.LoanBook(user);
//            user.updateUser(book);
//            userRepo.save(user);
//            bookRepo.save(book);
//        }
//        return "대여 되셨습니다.";
//    }
//
//    public String returnById(Long bookId, Long userId){
//        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));;
//        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Book not found with id: " + userId));
//        if(book.getIsLoan() == 0){
//            return "대여 할 수 있습니다.";
//        }
//        else {
//            user.updateUser(book);
//            book.returnBook(user);
//            userRepo.save(user);
//            bookRepo.save(book);
//        }
//        return "반납이 되었습니다.";
//    }
}
