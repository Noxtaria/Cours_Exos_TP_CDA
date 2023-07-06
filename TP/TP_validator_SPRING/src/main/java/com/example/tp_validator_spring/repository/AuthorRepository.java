package com.example.tp_validator_spring.repository;

import com.example.tp_validator_spring.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();
}
