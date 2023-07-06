package com.example.tp_validator_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du genre ne peut pas être vide")
    @Size(max = 10, message = "Le nom du genre ne peut pas dépasser 10 caractères")
    private String name;

    @Size(max = 200, message = "La description du genre ne peut pas dépasser 200 caractères")
    private String description;
}
