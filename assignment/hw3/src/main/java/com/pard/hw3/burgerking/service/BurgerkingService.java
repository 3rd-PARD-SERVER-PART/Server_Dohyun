package com.pard.hw3.burgerking.service;

import com.pard.hw3.burgerking.dto.BurgerkingDto;
import com.pard.hw3.burgerking.entity.Burgerking;
import com.pard.hw3.burgerking.repository.BurgerkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BurgerkingService {
    private final BurgerkingRepository burgerkingRepository;

    public void save(BurgerkingDto burgerkingDto){
        Burgerking burgerking = Burgerking.builder()
                .employeeName(burgerkingDto.getEmployeeName())
                .employeePosition(burgerkingDto.getEmployeePosition())
                .employeeSalary(burgerkingDto.getEmployeeSalary())
                .build();
        burgerkingRepository.save(burgerking);
    }

    public List<BurgerkingDto> readAll(){
        List<Burgerking> burgerkings = burgerkingRepository.findAll();
        return burgerkings.stream().map(burgerking -> BurgerkingDto.builder()
                .employeeName(burgerking.getEmployeeName())
                .employeePosition(burgerking.getEmployeePosition())
                .employeeSalary(burgerking.getEmployeeSalary())
                .build()).toList();
    }

    public void update(Long employeeId, BurgerkingDto burgerkingDto){
        Burgerking burgerking = burgerkingRepository.findById(employeeId).get();
        burgerking.setEmployeeName(burgerkingDto.getEmployeeName());
        burgerking.setEmployeeSalary(burgerkingDto.getEmployeeSalary());
        burgerking.setEmployeePosition(burgerking.getEmployeePosition());
        burgerkingRepository.save(burgerking);
    }

    public void delete(Long employeeId){
        burgerkingRepository.deleteById(employeeId);
    }

    public Long sumSalary(){
        List<Burgerking> burgerkings = burgerkingRepository.findAll();
        return burgerkings.stream()
                .mapToLong(Burgerking::getEmployeeSalary)
                .sum();
    }

    public Long isSalary(String position){
        Burgerking burgerking = burgerkingRepository.findBurgerkingByEmployeePosition(position);
        return burgerking.getEmployeeSalary();
    }

    public Long hisSalary(String name){
        Burgerking burgerking = burgerkingRepository.findBurgerkingByEmployeeName(name);
        return burgerking.getEmployeeSalary();
    }
}
