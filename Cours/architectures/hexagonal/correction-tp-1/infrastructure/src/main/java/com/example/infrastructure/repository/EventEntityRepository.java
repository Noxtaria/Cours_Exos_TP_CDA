package com.example.infrastructure.repository;

import com.example.infrastructure.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventEntityRepository extends CrudRepository<EventEntity, Integer> {
}
