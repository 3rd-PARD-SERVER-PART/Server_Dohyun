package com.pard.fourthseminar.book.repo;

import com.pard.fourthseminar.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
