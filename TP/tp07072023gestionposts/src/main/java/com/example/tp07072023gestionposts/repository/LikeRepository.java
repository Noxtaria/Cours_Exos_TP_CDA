package com.example.tp07072023gestionposts.repository;

import com.example.tp07072023gestionposts.entity.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
}
