package com.pard.hw5.user.repo;

import com.pard.hw5.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Jpa를 통해 직접 Repo를 설정 하지 않아도 다 해주긴 함.Repo는 Service가 요구하는 사항에 맞게 찾아주거나 만들어 주고 싶은 활동들을 통틀어 작용.
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByName(String name);
}
