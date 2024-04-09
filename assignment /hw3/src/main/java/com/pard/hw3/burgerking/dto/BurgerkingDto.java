package com.pard.hw3.burgerking.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BurgerkingDto {
    private String employeeName;
    private String employeePosition;
    private Long employeeSalary;
}
