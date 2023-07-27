package com.example.service;

import com.example.entity.Rapport;
import com.example.port.RapportPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RapportService {

    private final RapportPort rapportPort;

    @Autowired
    public RapportService(RapportPort rapportPort) {
        this.rapportPort = rapportPort;
    }

    public Rapport creerRapport(Rapport rapport) {
        return rapportPort.creerRapport(rapport);
    }

    public Rapport trouverRapportParId(Long id) {
        return rapportPort.trouverRapportParId(id);
    }

    public List<Rapport> trouverRapportsParLocalisation(double latitude, double longitude) {
        return rapportPort.trouverRapportsParLocalisation(latitude, longitude);
    }

    public List<Rapport> trouverRapportsParDate(LocalDateTime date) {
        return rapportPort.trouverRapportsParDate(date);
    }

    public List<Rapport> trouverRapportsRecents() {
        return rapportPort.trouverRapportsRecents();
    }

    public List<Rapport> trouverRapportsLesPlusConsultes() {
        return rapportPort.trouverRapportsLesPlusConsultes();
    }

    public void mettreAJourRapport(Rapport rapport) {
        rapportPort.mettreAJourRapport(rapport);
    }

    public void supprimerRapport(Long id) {
        rapportPort.supprimerRapport(id);
    }

    public Long obtenirNombreTotalRapports() {
        return rapportPort.obtenirNombreTotalRapports();
    }
}
