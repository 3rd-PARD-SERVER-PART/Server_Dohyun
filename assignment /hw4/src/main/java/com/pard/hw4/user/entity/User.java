package com.pard.hw4.user.entity;

import com.pard.hw4.book.entity.Book;
import com.pard.hw4.user.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String major;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    // method 방식은 update가 가능하다.
    public static User toEntity(UserDto.Create dto){
        return User.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .major(dto.getMajor())
                .build();
    }

    public void updateUser(Book book){
        if(book.getIsLoan() == 0) {
            this.books.add(book);
        }
        else if (book.getIsLoan() == 1){
            this.books.removeIf(b -> b.getBookId().equals(book.getBookId()));
        }
    }
}
