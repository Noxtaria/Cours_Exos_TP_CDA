package com.example.cours_hexagonal.infrastructure.memory.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {

    private int id;
    private String title;
    private String author;
}
