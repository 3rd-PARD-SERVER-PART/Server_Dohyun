package com.pard.fourthseminar.user.repo;

import com.pard.fourthseminar.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
