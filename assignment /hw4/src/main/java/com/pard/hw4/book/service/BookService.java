package com.pard.hw4.book.service;

import com.pard.hw4.book.dto.BookCreateDto;
import com.pard.hw4.book.dto.BookReadDto;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.book.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public void createBook(BookCreateDto dto){
        bookRepo.save(Book.toEntity(dto));
    }

    // 유저들 여러개 리스트 가져옴 (1,2,3,4,5)
    // 스트링으로 하나씩 나눔 1 / 2 / 3 / 4 / 5
    // map (1-> bookReadDto, 2->bookReadDto, ...
    // book book
    // map으로 나눈 객채를 collect로 모아서 list로 만든다. 근데 각각의 객체는 book
    public List<BookReadDto> findAll(){
        return bookRepo.findAll()
                .stream()
                .map(BookReadDto::new
                ).collect(Collectors.toList());
    }
}
