//package com.pard.hw4.user.controller;
//
//import com.pard.hw4.user.dto.UserDto;
//import com.pard.hw4.user.dto.UserLoanDto;
//import com.pard.hw4.user.service.UserLoanService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/loan")
//public class LoanController {
//    private final UserLoanService userLoanService;
//
//    @PostMapping
//    @RequestMapping("")
//    public String createLoan(@RequestBody UserLoanDto.Create dto){
//        userLoanService.createLoan(dto);
//        return "대출 되었습니다.";
//    }
//
//    @GetMapping
//    @RequestMapping("")
//    public List<UserLoanDto.Update> readAll(){
//        return userLoanService.findAll();
//    }
//    @RequestMapping("")
//    @PatchMapping
//    public String loanById(@RequestParam Long bookId, @RequestParam Long userId, @RequestBody UserDto.Create dto){
//        return userLoanService.loanById(bookId, userId);
//    }
//
//    @RequestMapping("/return")
//    @PatchMapping
//    public String returnById(@RequestParam Long bookId, @RequestParam Long userId){
//        return userLoanService.returnById(bookId, userId);
//    }
//}
