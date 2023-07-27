package org.example.port;

import org.example.entity.Report;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository {
    Report save(Report report);
    Report findById(int id);
    List<Report> findAll();
    List<Report> findAllByDate(LocalDateTime date);
    List<Report> findAllByLocation(double latitude, double longitude);
    void delete(Report report);
}
