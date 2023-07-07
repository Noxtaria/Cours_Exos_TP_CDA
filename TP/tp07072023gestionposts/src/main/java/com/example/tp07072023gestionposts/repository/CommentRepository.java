package com.example.tp07072023gestionposts.repository;

import com.example.tp07072023gestionposts.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
