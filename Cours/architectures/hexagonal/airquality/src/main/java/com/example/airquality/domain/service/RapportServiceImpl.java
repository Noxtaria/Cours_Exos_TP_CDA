package com.example.airquality.domain.service;

import com.example.airquality.domain.entity.Rapport;
import com.example.airquality.domain.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RapportServiceImpl implements RapportService {

    private final RapportRepository rapportRepository;

    @Autowired
    public RapportServiceImpl(RapportRepository rapportRepository) {
        this.rapportRepository = rapportRepository;
    }

    @Override
    public Rapport createRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    @Override
    public Rapport getRapportById(Long id) {
        return rapportRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rapport> getRapportsByLocation(double latitude, double longitude) {
        return rapportRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

    @Override
    public List<Rapport> getRapportsByDate(LocalDateTime date) {
        return rapportRepository.findByDate(date);
    }

    @Override
    public List<Rapport> getRecentRapports() {
        return rapportRepository.findAll();
    }

    @Override
    public void updateRapport(Rapport rapport) {
        rapportRepository.save(rapport);
    }

    @Override
    public void deleteRapport(Long id) {
        rapportRepository.deleteById(id);
    }
}
