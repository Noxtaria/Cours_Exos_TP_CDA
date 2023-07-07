package com.example.tp07072023gestionposts.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {

    private Long id;

    @NotNull
    @Size(max = 15)
    private String userName;

    @NotNull
    @Size(max = 8)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{2})(?=.*[@#$%^&+=]).*$",
             message = "Le mot de passe doit contenir au moins 1 caractère spécial, 1 majuscule, 1 minuscule et 2 chiffres")

    private String password;
}
