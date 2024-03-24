package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetMeUpController {
    @RequestMapping("/setup")
    public String setup(){
        return "김도현 / 26 / AI 컴뷰터 공학 심화 / 게임 ||| ";
    }

    @RequestMapping("/you")
    public String you(
            @RequestParam(defaultValue = "guest") String name,
            @RequestParam(defaultValue = "0") Integer age,
            @RequestParam(defaultValue = "nobe") String major,
            @RequestParam(defaultValue = "nobe") String hobby
    ){
        return "김도현 / 26 / AI 컴퓨터 공학 심화 / 게임 ||| 이름: " + name + " / 나이: "+ age + " / 전공: "+ major + " / 취미: "+ hobby;

    }
}
