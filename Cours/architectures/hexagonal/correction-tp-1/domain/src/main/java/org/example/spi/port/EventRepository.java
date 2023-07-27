package org.example.spi.port;

import org.example.entity.Event;

import java.util.List;

public interface EventRepository {
    void save(Event event);
    Event findById(int id);
    List<Event> findAll();
}
