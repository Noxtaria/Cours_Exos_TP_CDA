package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class RapportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double latitude;
    private double longitude;
    private LocalDateTime dateHeure;
    private String niveauPollution;
    private String commentaires;

    public RapportEntity() {
    }

    public RapportEntity(Long id, double latitude, double longitude, LocalDateTime dateHeure, String niveauPollution, String commentaires) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateHeure = dateHeure;
        this.niveauPollution = niveauPollution;
        this.commentaires = commentaires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getNiveauPollution() {
        return niveauPollution;
    }

    public void setNiveauPollution(String niveauPollution) {
        this.niveauPollution = niveauPollution;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public String toString() {
        return "RapportEntity{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dateHeure=" + dateHeure +
                ", niveauPollution='" + niveauPollution + '\'' +
                ", commentaires='" + commentaires + '\'' +
                '}';
    }
}