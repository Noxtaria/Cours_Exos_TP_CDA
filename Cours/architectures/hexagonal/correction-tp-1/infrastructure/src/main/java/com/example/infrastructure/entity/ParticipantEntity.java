package com.example.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "participant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantEntity {

    @Id
    private int id;

    private String name;

    @ManyToMany
    private List<EventEntity> events;
}
