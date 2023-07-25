package com.example.cours_hexagonal.domain.spi.port;

import com.example.cours_hexagonal.domain.entity.Book;
import java.util.List;
public interface BookRepository {
    void save(Book book);
    List<Book> getBooks();
    Book getBookById(int id);
    Book getBookByTitle(String title);
}
