package com.pard.hw3.burgerking.controller;

import com.pard.hw3.burgerking.dto.BurgerkingDto;
import com.pard.hw3.burgerking.service.BurgerkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/king")
public class BurgerkingController {
    private final BurgerkingService burgerkingService;

    @PostMapping("")
    public void save(@RequestBody BurgerkingDto burgerkingDto){
        burgerkingService.save(burgerkingDto);
    }

    @GetMapping("")
    public List<BurgerkingDto> readAll(){
        return burgerkingService.readAll();
    }

    @GetMapping("/sum")
    public Long sumSalary(){
        return burgerkingService.sumSalary();
    }

    @GetMapping("/salary")
    public Long getSalary(@RequestParam(value = "position") String position){
        return burgerkingService.isSalary(position);
    }

    @GetMapping("/{name}")
    public Long hisSalary(@PathVariable String name){
        return burgerkingService.hisSalary(name);
    }


    @PatchMapping("/{employeeId}")
    public void update(@PathVariable Long employeeId, @RequestBody BurgerkingDto burgerkingDto){
        burgerkingService.update(employeeId, burgerkingDto);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable Long employeeId){
        burgerkingService.delete(employeeId);
    }

}
