package com.example.thirdseminar.user.repo;

import com.example.thirdseminar.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserEmail(String userEmail);
}
