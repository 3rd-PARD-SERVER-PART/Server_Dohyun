package com.pard.hw4.book.controller;

import com.pard.hw4.book.dto.BookDto;
import com.pard.hw4.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public String createBook(@RequestBody BookDto.Create dto){
        bookService.createBook(dto);
        return  "도서관의 행복";
    }

    @GetMapping("")
    public List<BookDto.Read> findAll(){
        return bookService.findAll();
    }

    @RequestMapping("/loan")
    @PatchMapping
    public String loanById(@RequestParam Long bookId, @RequestParam Long userId){
        return bookService.loanById(bookId, userId);
    }

    @RequestMapping("/return")
    @PatchMapping
    public String returnById(@RequestParam Long bookId, @RequestParam Long userId){
        return bookService.returnById(bookId, userId);
    }
}
