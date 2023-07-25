package com.example.tp07072023gestionposts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @OneToMany(mappedBy = "comment")
    private List<Like> likes;

    @OneToMany(mappedBy = "comment")
    private List<Dislike> dislikes;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
