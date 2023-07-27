package com.example.cours_hexagonal.adapter;

import com.example.cours_hexagonal.domain.spi.port.BookAdapterService;
import com.example.cours_hexagonal.domain.spi.port.BookAdapterServiceImpl;
import com.example.cours_hexagonal.infrastructure.memory.BookMemoryRepositoryImpl;

public class ConsoleAdapter {
    private BookAdapterService bookAdapterService;

    public ConsoleAdapter() {
        bookAdapterService = new BookAdapterServiceImpl(new BookMemoryRepositoryImpl());
    }

    public void save() {
        String title = "test 1";
        String author = "author 1";
        bookAdapterService.save(title, author);
    }
}
