package com.pard.hw4.user.controller;

import com.pard.hw4.book.service.BookService;
import com.pard.hw4.user.dto.UserDto;
import com.pard.hw4.user.dto.UserLoanDto;
import com.pard.hw4.user.service.UserLoanService;
import com.pard.hw4.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final BookService bookService;
    private final UserLoanService userLoanService;
    @PostMapping("")
    @Operation(summary = "유저 등록", description = "여기서 쓰시면 됩니다.")
    public String createUser(@RequestBody UserDto.Create dto){
        userService.createUser(dto);
        return "추가됨";
    }

    @GetMapping("")
    public List<UserDto.Read> readAll(){
        return userService.readAll();
    }

    @GetMapping("/{userId}")
    public UserDto.Read readById(@PathVariable Long userId) { return userService.readById(userId); }

    @PostMapping("/loan")
    @Operation(summary = "대출 허실..?", description = "해당 user의 id와 책의 id를 통해 빌릴 수 있습니다.")
    public String loanedBook(@RequestBody UserLoanDto.Create dto){
        return userLoanService.borrowBook(dto);
    }
}
