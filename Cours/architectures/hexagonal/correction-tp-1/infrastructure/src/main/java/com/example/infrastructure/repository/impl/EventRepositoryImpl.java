package com.example.infrastructure.repository.impl;

import com.example.infrastructure.entity.EventEntity;
import com.example.infrastructure.repository.EventEntityRepository;
import org.example.entity.Event;
import org.example.spi.port.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @Autowired
    private EventEntityRepository eventEntityRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(Event event) {
        EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
        eventEntityRepository.save(eventEntity);
    }

    @Override
    public Event findById(int id) {
        Optional<EventEntity> eventEntityOptional = eventEntityRepository.findById(id);
        if(eventEntityOptional.isPresent()) {
            return modelMapper.map(eventEntityOptional.get(), Event.class);
        }
        throw new RuntimeException("Event Not found");
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        eventEntityRepository.findAll().forEach(e -> {
            events.add(modelMapper.map(e, Event.class));
        });
        return events;
    }
}
