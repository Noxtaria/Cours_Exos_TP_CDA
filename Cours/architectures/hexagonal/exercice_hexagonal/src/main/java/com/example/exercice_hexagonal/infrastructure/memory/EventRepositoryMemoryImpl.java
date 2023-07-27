package com.example.exercice_hexagonal.memory;

import com.example.exercice_hexagonal.domain.entities.Event;
import com.example.exercice_hexagonal.domain.spi.EventRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventRepositoryMemoryImpl implements EventRepository {
    private Map<Integer, Event> eventMap = new HashMap<>();
    private int nextEventId = 1;

    @Override
    public void save(Event event) {
        if (event.getEventId() == 0) {
            event.setEventId(nextEventId++);
        }
        eventMap.put(event.getEventId(), event);
    }

    @Override
    public Event findById(int eventId) {
        return eventMap.get(eventId);
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(eventMap.values());
    }
}
