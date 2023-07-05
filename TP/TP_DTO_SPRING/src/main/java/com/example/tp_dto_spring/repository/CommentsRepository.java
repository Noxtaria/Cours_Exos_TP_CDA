package com.example.tp_dto_spring.repository;

import com.example.tp_dto_spring.entity.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {
    List<Comments> findByPostsId(Long postId);

    Optional<Comments> findByIdAndPostsId(Long commentId, Long postId);
}
