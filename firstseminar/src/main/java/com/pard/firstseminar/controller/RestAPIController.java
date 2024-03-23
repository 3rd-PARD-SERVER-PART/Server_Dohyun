package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/user")
public class RestAPIController {
    @GetMapping("/userId")
    public String hi(@PathVariable Integer userId){
        return "Get으로 받은 userId" + userId;
    }

    @GetMapping
    public String userAll(){
        return "Post: Usercreate";
    }
    @PutMapping
    public String userUpdate(){
        return "Put: user Update";
    }
    @PatchMapping
    public String userUpdateByPatch(){
        return "Patch: user Update";
    }
    @DeleteMapping
    public String userDelete(){
        return "Delete: user Delete";
    }
}
    // 과제 -> 자기 이름, 나이, 학과, 취미 다 나오게 하고 --> 옆 짝꿍 거 컨트롤러 받아서 들어가서 // 저장 x
    // 127.0.0.1 == localhost