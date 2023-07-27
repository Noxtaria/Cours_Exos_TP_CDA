package com.example.cours_hexagonal.domain.spi.port;

import com.example.cours_hexagonal.domain.entity.Book;
import com.example.cours_hexagonal.domain.service.BookService;

import java.util.List;

public class BookAdapterServiceImpl implements BookAdapterService {

    private BookService bookService;

    public BookAdapterServiceImpl(BookRepository bookRepository) {
        bookService = new BookService( bookRepository);
    }
    @Override
    public void save(String title, String author) {
        bookService.save(title, author);
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }
}
