package com.example.cours_hexagonal.infrastructure.memory;

import com.example.cours_hexagonal.domain.entity.Book;
import com.example.cours_hexagonal.domain.spi.port.BookRepository;
import com.example.cours_hexagonal.infrastructure.memory.entity.BookEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMemoryRepositoryImpl implements BookRepository {

    public Map<Integer, BookEntity> books = new HashMap<>();
    private static int count = 0;

    @Override
    public void save(Book book) {
        //Mapper pour convertir un Book en BookEntity
        BookEntity bookEntity = BookEntity.builder().title(book.getTitle()).author(book.getAuthor()).build();
        books.put(++count, bookEntity);
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public Book getBookByTitle(String title) {
        return null;
    }
}
