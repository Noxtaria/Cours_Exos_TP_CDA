package com.example.tp_validator_spring.repository;

import com.example.tp_validator_spring.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findAll();
}
