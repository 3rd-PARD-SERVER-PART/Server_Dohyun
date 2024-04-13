package com.pard.fourthseminar.user.controller;

import com.pard.fourthseminar.user.dto.UserDto;
import com.pard.fourthseminar.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private  final UserService userService;

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
}
