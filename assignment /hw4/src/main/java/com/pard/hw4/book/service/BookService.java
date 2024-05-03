package com.pard.hw4.book.service;

import com.pard.hw4.book.dto.BookDto;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.book.repo.BookRepo;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    public void createBook(BookDto.Create dto){
        bookRepo.save(Book.toEntity(dto));
    }

    // 유저들 여러개 리스트 가져옴 (1,2,3,4,5)
    // 스트링으로 하나씩 나눔 1 / 2 / 3 / 4 / 5
    // map (1-> bookReadDto, 2->bookReadDto, ...
    // book book
    // map으로 나눈 객채를 collect로 모아서 list로 만든다. 근데 각각의 객체는 book
    public List<BookDto.Read> findAll(){
        return bookRepo.findAll()
                .stream()
                .map(BookDto.Read::new
                ).collect(Collectors.toList());
    }
    public String loanById(Long bookId, Long userId){
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));;
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Book not found with id: " + userId));
        if(book.getIsLoan() == 1){
            return "대여 할 수 없습니다...";
        }
        else {
            book.LoanBook(user);
            user.updateUser(book);
            userRepo.save(user);
            bookRepo.save(book);
        }
        return "대여 되셨습니다.";
    }

    public String returnById(Long bookId, Long userId){
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));;
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Book not found with id: " + userId));
        if(book.getIsLoan() == 0){
            return "대여 할 수 있습니다.";
        }
        else {
            book.returnBook(user);
            userRepo.save(user);
            bookRepo.save(book);
        }
        return "반납이 되었습니다.";
    }
}
