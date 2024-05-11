package com.pard.hw5.book.controller;

import com.pard.hw5.book.dto.BookDto;
import com.pard.hw5.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    @Operation(summary = "도서관 책 입점", description = "도서관에 책을 적립(?)할 수 있는 방법에 대해 알려줌.")
    public String createBook(@RequestBody BookDto.Create dto){
        bookService.createBook(dto);
        return  "도서관의 행복";
    }

    @GetMapping("")
    @Operation(summary = "도서관 책 목록",description = "도서괸에 있는 모든 책의 목록을 알수 있는 방법.")
    public List<BookDto.Read> findAll(){
        return bookService.findAll();
    }

}
