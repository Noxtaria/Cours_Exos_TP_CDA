package com.example.airquality.domain.repository;

import com.example.airquality.domain.entity.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {
    List<Rapport> findByLatitudeAndLongitude(double latitude, double longitude);
    List<Rapport> findByDate(LocalDateTime date);


}
