package com.pard.fourthseminar.book.controller;

import com.pard.fourthseminar.book.dto.BookCreateDto;
import com.pard.fourthseminar.book.dto.BookReadDto;
import com.pard.fourthseminar.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public String createBook(@RequestBody BookCreateDto dto){
        bookService.createBook(dto);
        return  "추가됨";
    }

    @GetMapping("")
    public List<BookReadDto> findAll(){
        return bookService.findAll();
    }

}
