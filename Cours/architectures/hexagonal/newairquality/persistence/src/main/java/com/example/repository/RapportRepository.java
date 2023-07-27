package com.example.repository;

import com.example.entity.RapportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapportRepository extends JpaRepository<RapportEntity, Long> {
    List<RapportEntity> findAllByLatitudeAndLongitude(double latitude, double longitude);
}
