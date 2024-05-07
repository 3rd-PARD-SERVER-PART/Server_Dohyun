package com.pard.hw3.burgerking.repository;

import com.pard.hw3.burgerking.entity.Burgerking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerkingRepository extends JpaRepository<Burgerking, Long> {
    public Burgerking findBurgerkingByEmployeeName(String employeeName);
    public Burgerking findBurgerkingByEmployeePosition(String employeePosition);

}
