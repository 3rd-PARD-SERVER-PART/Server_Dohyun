package com.prad.SecondSeminar.Controller;

import lombok.RequiredArgsConstructor;
import com.prad.SecondSeminar.Service.UserService;
import org.springframework.web.bind.annotation.*;
import com.prad.SecondSeminar.UserDto.UserDto

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/find/{studentId}")
    public UserDto findById(@PathVariable Integer studentId){
        return userService.findById(studentId);
    }

    @PatchMapping("/update/{studentId}")
    public void update(@PathVariable Integer studentId, @RequestBody UserDto userDto){
        userService.update(studentId, userDto);
    }
    @DeleteMapping("/delete/{studentId}")
    public void delete(@PathVariable Integer studentId){
        userService.delete(studentId);
    }
}