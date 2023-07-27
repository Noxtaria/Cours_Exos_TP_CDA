package com.example.port;

import com.example.entity.Rapport;

import java.time.LocalDateTime;
import java.util.List;

public interface RapportPort {
    Rapport creerRapport(Rapport rapport);

    Rapport trouverRapportParId(Long id);

    List<Rapport> trouverRapportsParLocalisation(double latitude, double longitude);

    List<Rapport> trouverRapportsParDate(LocalDateTime date);

    List<Rapport> trouverRapportsRecents();

    List<Rapport> trouverRapportsLesPlusConsultes();

    void mettreAJourRapport(Rapport rapport);

    void supprimerRapport(Long id);

    Long obtenirNombreTotalRapports();

}