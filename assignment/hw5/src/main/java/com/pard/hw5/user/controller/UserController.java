package com.pard.hw5.user.controller;

import com.pard.hw5.user.dto.UserDto;
import com.pard.hw5.user.dto.UserLoanDto;
import com.pard.hw5.user.service.UserLoanService;
import com.pard.hw5.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserLoanService userLoanService;
    @PostMapping("")
    @Operation(summary = "유저 등록", description = "여기서 쓰시면 됩니다.")
    public String createUser(@RequestBody UserDto.Create dto){
        userService.createUser(dto);
        return "추가됨";
    }

    @GetMapping("")
    @Operation(summary = "user들의 모든 정보", description = "모든 user의 정보를 알아보는 시간을 가져보자.")
    public List<UserDto.Read> readAll(){
        return userService.readAll();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "해당 ID를 갖은 유저 확인", description = "userId를 통해 유저의 정보를 찾아낸다.")
    public UserDto.Read readById(@PathVariable Long userId) { return userService.readById(userId); }

    @GetMapping("/loan")
    @Operation(summary = "모든 대출 기록 확인", description = "대출 되었거나 안된 모든 대출기록을 확인한다.")
    public List<UserLoanDto.Update> findAll(){ return userLoanService.findAll(); }

    @PostMapping("/loan")
    @Operation(summary = "대출 허실..?", description = "해당 user의 id와 책의 id를 통해 빌릴 수 있습니다.")
    public String loanBook(@RequestBody UserLoanDto.Create dto){
        return userLoanService.borrowBook(dto);
    }

    @PostMapping("/return")
    @Operation(summary = "반납 허실..?", description = "빌린 책의 Id값을 얻으면 반납이 가능한지 못하는지 확인과 반납을 실시해준다.")
    public String returnBook(@RequestParam Long loanBookId){
        return userLoanService.returnBook(loanBookId);
    }
}
