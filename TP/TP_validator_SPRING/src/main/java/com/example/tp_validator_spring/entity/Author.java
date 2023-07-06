package com.example.tp_validator_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'auteur ne peut pas être vide")
    @Size(max = 50, message = "Le nom de l'auteur ne peut pas dépasser 50 caractères")
    private String name;

    @NotBlank(message = "L'adresse email de l'auteur ne peut pas être vide")
    @Email(message = "L'adresse email de l'auteur doit être au format : test@example.com")
    private String email;
}
