package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestParamController {
    @RequestMapping("/basic")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") int age ) {
        return "연습 name : " + name + "age : " + age;
    }
    // 다 각자의 컨트롤러 만든 것들. 따로따로 가낟.
    @RequestMapping("/v2")
    public String requestParamV2(
            @RequestParam String name,
            @RequestParam int age
    ){
        return "연습 name : " + name + ", age : " + age;
    }

    @RequestMapping("/v3")
    public String requestParamV3(
            String name,
            int age
    ){
        return "연습 name : " + name + ", age : " + age;
    }

    @RequestMapping("/v4")
    public String requestParemV4(
            @RequestParam(defaultValue = "quest") String name,
            @RequestParam(defaultValue = "0") Integer age
            // int, flaut 는 null 값을 못받는다. // 원시함수 써라 Long,  Integer,...
    ) {
        return "연습 5 name : " + name + ", age : " + age;
    }

    @RequestMapping("/map")
    public String requentParam6(@RequestParam Map<String, Object> paraMap){
        return "연습 6 name : " + paraMap.get("name") + ", age : " + paraMap.get("age");
    }
}
