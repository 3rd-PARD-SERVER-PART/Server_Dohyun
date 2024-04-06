package com.example.thirdseminar.user.service;

import com.example.thirdseminar.user.dto.UserDto;
import com.example.thirdseminar.user.entity.User;
import com.example.thirdseminar.user.repo.UserRepository;
import jakarta.transaction.UserTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void save(UserDto userDto){
        User user = User.builder()
                .userEmail(userDto.getEmail())
                .userPassword(userDto.getPassword())
                .build();
        userRepository.save(user);
    }


    public UserDto read (Long userId){
        User user = userRepository.findById(userId).get();
        return UserDto.builder()
                .email(user.getUserEmail())
                .password(user.getUserPassword())
                .build();
    }

    public List<UserDto> readAll(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user ->
                UserDto.builder()
                        .email(user.getUserEmail())
                        .password(user.getUserPassword())
                        .build()).toList();
        return userDtos;
    }

    public void update(Long userId, UserDto userDto)
    {
        User user = userRepository.findById(userId).get();
        user.setUserEmail(userDto.getEmail());
        user.setUserPassword(userDto.getPassword());
        userRepository.save(user);
    }

    public void delete (Long userId){
        userRepository.deleteById(userId);
    }
    //Email 로 userId찾기
    public Long getUserNum(String email){
        User user = userRepository.findByUserEmail(email);
        return user.getUserID();
    }
}
