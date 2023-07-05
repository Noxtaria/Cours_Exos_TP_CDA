package com.example.tp_dto_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsDto {
    private Long id;
    private String title;
    private String content;
    private String description;
}
