package com.example.airquality.domain.service;

import com.example.airquality.domain.entity.Rapport;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface RapportService {
    Rapport createRapport(Rapport rapport);

    Rapport getRapportById(Long id);

    List<Rapport> getRapportsByLocation(double latitude, double longitude);

    List<Rapport> getRapportsByDate(LocalDateTime date);

    List<Rapport> getRecentRapports();

    void updateRapport(Rapport rapport);

    void deleteRapport(Long id);
}
