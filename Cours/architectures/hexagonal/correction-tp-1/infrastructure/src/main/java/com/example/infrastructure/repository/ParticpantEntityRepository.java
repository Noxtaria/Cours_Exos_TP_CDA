package com.example.infrastructure.repository;

import com.example.infrastructure.entity.ParticipantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticpantEntityRepository extends CrudRepository<ParticipantEntity, Integer> {
}
