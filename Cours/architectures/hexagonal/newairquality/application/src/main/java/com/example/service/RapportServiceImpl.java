package com.example.service;

import com.example.entity.Rapport;
import com.example.port.RapportPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RapportServiceImpl implements RapportPort {

    private final List<Rapport> rapports = new ArrayList<>();
    private long dernierId = 0;

    @Override
    public Rapport creerRapport(Rapport rapport) {
        rapport.setId(++dernierId);

        rapports.add(rapport);

        return rapport;
    }

    @Override
    public Rapport trouverRapportParId(Long id) {
        for (Rapport rapport : rapports) {
            if (rapport.getId().equals(id)) {
                return rapport;
            }
        }
        return null;
    }

    @Override
    public List<Rapport> trouverRapportsParLocalisation(double latitude, double longitude) {
        List<Rapport> rapportsTrouves = new ArrayList<>();
        for (Rapport rapport : rapports) {
            if (rapport.getLatitude() == latitude && rapport.getLongitude() == longitude) {
                rapportsTrouves.add(rapport);
            }
        }
        return rapportsTrouves;
    }

    @Override
    public List<Rapport> trouverRapportsParDate(LocalDateTime date) {
        List<Rapport> rapportsTrouves = new ArrayList<>();
        for (Rapport rapport : rapports) {
            if (rapport.getDateHeure().equals(date)) {
                rapportsTrouves.add(rapport);
            }
        }
        return rapportsTrouves;
    }

    @Override
    public List<Rapport> trouverRapportsRecents() {
        List<Rapport> rapportsRecents = new ArrayList<>();
        LocalDateTime maintenant = LocalDateTime.now();
        for (Rapport rapport : rapports) {
            if (rapport.getDateHeure().isAfter(maintenant.minusDays(7))) {
                rapportsRecents.add(rapport);
            }
        }
        return rapportsRecents;
    }

    @Override
    public List<Rapport> trouverRapportsLesPlusConsultes() {
        Map<Rapport, Integer> consultationsParRapport = new HashMap<>();
        for (Rapport rapport : rapports) {
            int consultations = consultationsParRapport.getOrDefault(rapport, 0);
            consultationsParRapport.put(rapport, consultations + 1);
        }

        List<Rapport> rapportsLesPlusConsultes = new ArrayList<>();
        int maxConsultations = 0;
        for (Map.Entry<Rapport, Integer> entry : consultationsParRapport.entrySet()) {
            int consultations = entry.getValue();
            if (consultations > maxConsultations) {
                maxConsultations = consultations;
                rapportsLesPlusConsultes.clear();
                rapportsLesPlusConsultes.add(entry.getKey());
            } else if (consultations == maxConsultations) {
                rapportsLesPlusConsultes.add(entry.getKey());
            }
        }

        return rapportsLesPlusConsultes;
    }

    @Override
    public void mettreAJourRapport(Rapport rapport) {
        for (int i = 0; i < rapports.size(); i++) {
            Rapport rapportExistant = rapports.get(i);
            if (rapportExistant.getId().equals(rapport.getId())) {
                rapportExistant.setLatitude(rapport.getLatitude());
                rapportExistant.setLongitude(rapport.getLongitude());
                rapportExistant.setDateHeure(rapport.getDateHeure());
                rapportExistant.setNiveauPollution(rapport.getNiveauPollution());
                rapportExistant.setCommentaires(rapport.getCommentaires());
                break;
            }
        }
    }

    @Override
    public void supprimerRapport(Long id) {
        rapports.removeIf(rapport -> rapport.getId().equals(id));
    }

    @Override
    public Long obtenirNombreTotalRapports() {
        return (long) rapports.size();
    }

}
