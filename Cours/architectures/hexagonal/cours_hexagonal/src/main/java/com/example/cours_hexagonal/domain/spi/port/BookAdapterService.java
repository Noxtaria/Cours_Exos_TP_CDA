package com.example.cours_hexagonal.domain.spi.port;

import com.example.cours_hexagonal.domain.entity.Book;

import java.util.List;

public interface BookAdapterService {
    void save(Book book);
    Book getBookById(Book book);
    List<Book> getBooks();
}
