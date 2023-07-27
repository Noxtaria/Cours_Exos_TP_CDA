package com.example.infrastructurespringdata.repository;

import com.example.infrastructurespringdata.entity.ReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReportEntityRepository extends CrudRepository<ReportEntity, Integer> {

    List<ReportEntity> findAllByDate(LocalDateTime dateTime);
    List<ReportEntity> findAllByLatitudeAndLongitude(double latitude, double longitude);
}
