package com.example.tp07072023gestionposts.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentDto {
    private Long id;

    @NotNull
    @Size(max = 500)
    private String message;
}
