package com.example.exercice_hexagonal.domain.service;

import com.example.exercice_hexagonal.domain.entities.Event;
import com.example.exercice_hexagonal.domain.spi.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(String title, String date, String description) {
        Event event = new Event(0, title, date, description, new ArrayList<>());
        eventRepository.save(event);
    }

    public void registerForEvent(int eventId, int participantId) {
        Event event = eventRepository.findById(eventId);
    }

    public List<Event> listUpcomingEvents() {
        return eventRepository.findAll();
    }

    public Event findEventById(int eventId) {
        return eventRepository.findById(eventId);
    }
}