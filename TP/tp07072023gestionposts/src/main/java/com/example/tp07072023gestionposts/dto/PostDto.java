package com.example.tp07072023gestionposts.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostDto {
    private Long id;

    @NotNull
    @Size(min = 4, max = 15)
    private String title;

    @Size(max = 250)
    private String text;
}
