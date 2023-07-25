package com.example.tp07072023gestionposts.repository;

import com.example.tp07072023gestionposts.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
