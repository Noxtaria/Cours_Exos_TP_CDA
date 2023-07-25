package com.example.cours_hexagonal.domain.service;

import com.example.cours_hexagonal.domain.entity.Book;
import com.example.cours_hexagonal.domain.spi.port.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(String title, String author) {
        Book bookExist = bookRepository.getBookByTitle(title);
        if (bookExist == null || !bookExist.getAuthor().equals(author)) {
            Book book = new Book(title, author);
            this.bookRepository.save(book);
        }
        throw new RuntimeException("Book exist");
    }
}
