//package com.pard.hw4.user.service;
//
//import com.pard.hw4.book.dto.BookReadDto;
//import com.pard.hw4.book.repo.BookRepo;
//import com.pard.hw4.user.dto.UserDto;
//import com.pard.hw4.user.dto.UserLoanDto;
//import com.pard.hw4.user.entity.LoanBookHistory;
//import com.pard.hw4.user.repo.UserLoanRepo;
//import com.pard.hw4.user.repo.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@Service
//public class UserLoanService {
//    private final BookRepo bookRepo;
//    private final UserRepo userRepo;
//    private final UserLoanRepo userLoanRepo;
//
//
//    public void createLoan(UserLoanDto.Create dto){
//        userLoanRepo.save(LoanBookHistory.toEntity(dto,
//                userRepo.findById(dto.getUser().getId()).orElseThrow(),
//                bookRepo.findById(dto.getBook().getBookId()).orElseThrow()));
//    }
//
//    public List<UserLoanDto.Update> findAll(){
//        return userLoanRepo.findAll()
//                .stream()
//                .map(loanBookHistory -> new UserLoanDto.Update(loanBookHistory,
//                        new UserDto.Read(loanBookHistory.getUser()),
//                        new BookReadDto(loanBookHistory.getBook()))
//                ).collect(Collectors.toList());
//    }
////    public String loanById(Long bookId, Long userId){
////        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));;
////        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Book not found with id: " + userId));
////
////        return "대여 되셨습니다.";
////    }
////
////    public String returnById(Long bookId, Long userId){
////        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));;
////        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Book not found with id: " + userId));
////        if(book.getIsLoan() == 0){
////            return "대여 할 수 있습니다.";
////        }
////        else {
////            user.updateUser(book);
////            book.returnBook(user);
////            userRepo.save(user);
////            bookRepo.save(book);
////        }
////        return "반납이 되었습니다.";
////    }
//}
