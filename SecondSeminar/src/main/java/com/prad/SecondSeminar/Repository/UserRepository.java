package com.prad.SecondSeminar.Repository;


import com.prad.SecondSeminar.User;
import com.prad.SecondSeminar.UserDto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();

    //    Create
    public void save(UserDto userDto){
        User u = User.builder()
                .studentId(userDto.getStudentId())
                .studentName(userDto.getStudentName())
                .build();
        handong.put(userDto.getStudentId(), u);
    }

    //    Read
    public UserDto findById(Integer studentId){
        User user = handong.get(studentId);
        if(user == null){
            System.out.println("student Id 없음");
        }
        return UserDto.builder()
                .studentName(user.getStudentName())
                .studentId(user.getStudentId())
                .build();
    }
    public List<UserDto> findAll(){
        return handong.values().stream()
                .map(user -> UserDto.builder()
                        .studentId(user.getStudentId())
                        .studentName(user.getStudentName())
                        .build()
                ).toList();

        //    List<UserDto> userDtos = new ArrayList<>();
        // for (User user : handong.values()) {
        //   UserDto userDto = UserDto.builder()
        //           .studentId(user.getStudnetId())
        //         .studentName(user.getStudentName())
        //       .build();
        //userDtos.add(userDto);
        //}
        //return userDtos;
    }

    public void update(Integer studentId,UserDto userDto){
        User user = handong.get(studentId);
        user.setStudentId(userDto.getStudentId());
        user.setStudentName(userDto.getStudentName());
        handong.put(userDto.getStudentId(), user);
    }
    public void delete(Integer studentId){
        handong.remove(studentId);
    }
}