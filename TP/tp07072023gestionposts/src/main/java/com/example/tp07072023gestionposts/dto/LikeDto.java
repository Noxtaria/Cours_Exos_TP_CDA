package com.example.tp07072023gestionposts.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class LikeDto {
    private Long id;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
}
