package com.pard.hw5.user.repo;

import com.pard.hw5.book.entity.Book;
import com.pard.hw5.user.entity.LoanBookHistory;
import com.pard.hw5.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanRepo extends JpaRepository<LoanBookHistory, Long> {
    UserLoanRepo findByUserAndBook(User user, Book book);
}
