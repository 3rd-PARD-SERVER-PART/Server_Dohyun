package com.pard.hw4.user.repo;

import com.pard.hw4.user.entity.LoanBookHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanRepo extends JpaRepository<LoanBookHistory, Long> {
}
