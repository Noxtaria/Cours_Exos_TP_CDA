package com.example.adapter;

import com.example.entity.Rapport;
import com.example.entity.RapportEntity;
import com.example.port.RapportPort;
import com.example.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RapportPersistenceAdapter implements RapportPort {

    private final RapportRepository rapportRepository;

    @Autowired
    public RapportPersistenceAdapter(RapportRepository rapportRepository) {
        this.rapportRepository = rapportRepository;
    }

    @Override
    public Rapport creerRapport(Rapport rapport) {
        RapportEntity rapportEntity = mapToEntity(rapport);
        rapportEntity = rapportRepository.save(rapportEntity);
        return mapToDomain(rapportEntity);
    }

    @Override
    public Rapport trouverRapportParId(Long id) {
        return rapportRepository.findById(id).map(this::mapToDomain).orElse(null);
    }

    @Override
    public List<Rapport> trouverRapportsParLocalisation(double latitude, double longitude) {
        List<RapportEntity> rapportsEntities = rapportRepository.findAllByLatitudeAndLongitude(latitude, longitude);
        return rapportsEntities.stream().map(this::mapToDomain).collect(Collectors.toList());
    }

    @Override
    public List<Rapport> trouverRapportsParDate(LocalDateTime date) {
        return null;
    }

    @Override
    public List<Rapport> trouverRapportsRecents() {
        return null;
    }

    @Override
    public List<Rapport> trouverRapportsLesPlusConsultes() {
        return null;
    }

    @Override
    public void mettreAJourRapport(Rapport rapport) {

    }

    @Override
    public void supprimerRapport(Long id) {

    }

    @Override
    public Long obtenirNombreTotalRapports() {
        return null;
    }

    private RapportEntity mapToEntity(Rapport rapport) {
        RapportEntity rapportEntity = new RapportEntity();
        rapportEntity.setLatitude(rapport.getLatitude());
        rapportEntity.setLongitude(rapport.getLongitude());
        rapportEntity.setDateHeure(rapport.getDateHeure());
        rapportEntity.setNiveauPollution(rapport.getNiveauPollution());
        rapportEntity.setCommentaires(rapport.getCommentaires());
        return rapportEntity;
    }

    private Rapport mapToDomain(RapportEntity rapportEntity) {
        return new Rapport(
                rapportEntity.getId(),
                rapportEntity.getLatitude(),
                rapportEntity.getLongitude(),
                rapportEntity.getDateHeure(),
                rapportEntity.getNiveauPollution(),
                rapportEntity.getCommentaires()
        );
    }
}