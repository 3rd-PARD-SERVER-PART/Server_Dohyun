package com.example.thirdseminar.user.controller;

import com.example.thirdseminar.user.dto.UserDto;
import com.example.thirdseminar.user.entity.User;
import com.example.thirdseminar.user.repo.UserRepository;
import com.example.thirdseminar.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class Controller {

    private final UserService userService;

    @PostMapping("")
    public void save(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto readById(@PathVariable Long userId){
        return userService.read(userId);
    }

/*
 * <안에 있느ㄴ선 리턴 값을 뜻함.>
 */
    @GetMapping("/userNum")
    public ResponseEntity<Long> read(@RequestParam String email){
        Long returnToClient = userService.getUserNum(email);
        return new ResponseEntity<>(returnToClient, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<UserDto> readAll(){
        return userService.readAll();
    }

    @PatchMapping("/update/{userId}")
    public void update(@PathVariable Long userId, @RequestBody UserDto userDto){
        userService.update(userId,userDto);
    }

    @DeleteMapping("/{userID}")
    public void delete(@PathVariable Long userID){
        userService.delete(userID);
    }
}
