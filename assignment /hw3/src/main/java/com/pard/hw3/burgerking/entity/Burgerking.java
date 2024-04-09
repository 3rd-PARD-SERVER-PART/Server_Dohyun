package com.pard.hw3.burgerking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Burgerking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(name = "name", length = 20)
    private String employeeName;
    @Column(name = "position")
    private String employeePosition;
    @Column(name = "salary")
    private Long employeeSalary;
}
