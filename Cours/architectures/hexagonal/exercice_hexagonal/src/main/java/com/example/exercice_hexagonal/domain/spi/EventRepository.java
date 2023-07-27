package com.example.exercice_hexagonal.domain.spi;

import com.example.exercice_hexagonal.domain.entities.Event;

import java.util.List;

public interface EventRepository {
    void save(Event event);
    Event findById(int eventId);
    List<Event> findAll();
}
