package com.pard.hw5.user.repo;

import com.pard.hw5.user.entity.LoanBookHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanRepo extends JpaRepository<LoanBookHistory, Long> {
}
