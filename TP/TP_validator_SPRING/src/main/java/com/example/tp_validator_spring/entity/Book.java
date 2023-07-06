package com.example.tp_validator_spring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre ne peut être vide")
    @Size(max = 255, message = "Le titre ne peut pas dépasser 255 caractères" )
    private String title;

    @ManyToOne
    @NotNull(message = "L'auteur ne peut pas être null")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull(message = "L'auteur ne peut pas être null")
    private Author author;

    @Positive(message = "L'année de publication doit être un entier positif")
    @Max(value = 2023, message = "L'année de publication ne peut pas être supérieure à 2023")
    private Integer publicationYear;
}
