package com.pard.hw4.user.service;

import com.pard.hw4.user.dto.UserDto;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void createUser(UserDto.Create dto){
        userRepo.save(User.toEntity(dto));
    }

    public UserDto.Read readById(Long userId){
        User user = userRepo.findById(userId).get();
        return new UserDto.Read(user);
    }

    public List<UserDto.Read> readAll(){
        return userRepo.findAll()
                .stream()
                .map(UserDto.Read::new)
                .collect(Collectors.toList());
    }
}
