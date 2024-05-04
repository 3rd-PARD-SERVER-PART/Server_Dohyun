package com.pard.hw4.user.service;

import com.pard.hw4.book.dto.BookDto;
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
        return new UserDto.Read(user, user.getBooks().stream()
                .map(BookDto.Read::new)
                .collect(Collectors.toList()));
    }

    public List<UserDto.Read> readAll(){
        // 유저들 여러개 리스트 가져옴 (1,2,3,4,5)
        // 스트링으로 하나씩 나눔 1 / 2 / 3 / 4 / 5
        // map (1->
        // User user
        return userRepo.findAll()
                .stream()
                .map(user -> new UserDto.Read(user,
                        user.getBooks().stream()
                                .map(BookDto.Read::new)
                                .collect(Collectors.toList()))
                ).collect(Collectors.toList());
    }
}
