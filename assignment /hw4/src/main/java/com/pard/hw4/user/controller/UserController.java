package com.pard.hw4.user.controller;

import com.pard.hw4.book.service.BookService;
import com.pard.hw4.user.dto.UserDto;
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

    @RequestMapping("/loan")
    @PatchMapping
    public String loanById(@RequestParam Long bookId, @RequestParam Long userId){
        return bookService.loanById(bookId, userId);
    }

    @RequestMapping("/return")
    @PatchMapping
    public String returnById(@RequestParam Long bookId, @RequestParam Long userId){
        return bookService.returnById(bookId, userId);
    }
}
