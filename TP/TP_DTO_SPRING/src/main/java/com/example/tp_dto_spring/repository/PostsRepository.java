package com.example.tp_dto_spring.repository;

import com.example.tp_dto_spring.entity.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Long> {
}
