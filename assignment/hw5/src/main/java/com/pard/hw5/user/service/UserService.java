package com.pard.hw5.user.service;

import com.pard.hw5.user.dto.UserDto;
import com.pard.hw5.user.entity.User;
import com.pard.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//client가 원하는 정보를 전달하거나 저장하는 직접적인 작용을 함. controller 에서 보낸 정보를 바탕으로 행동을 한다.
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
