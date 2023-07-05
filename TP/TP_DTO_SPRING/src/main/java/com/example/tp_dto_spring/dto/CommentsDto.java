package com.example.tp_dto_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
    private Long id;
    private String body;
    private String name;
    private String email;
    private Long postId;
}
