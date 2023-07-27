package org.example.service;

import org.example.entity.Event;
import org.example.entity.Participant;
import org.example.spi.port.EventRepository;
import org.example.spi.port.ParticipantRepository;

import java.util.Date;
import java.util.List;

public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ParticipantRepository participantRepository;

    public EventServiceImpl(EventRepository eventRepository, ParticipantRepository participantRepository) {
        this.eventRepository = eventRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public void createEvent(String title, Date date, String description) {
        //Après vérification des champs par exemple
        Event event = new Event(title, date, description);
        try {
            this.eventRepository.save(event);
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void registerForEvent(int eventId, int participantId) {
        Event event = eventRepository.findById(eventId);
        if(event != null) {
            Participant participant = participantRepository.findById(participantId);
            if(participant != null) {
                event.getParticipants().add(participant);
                try {
                    eventRepository.save(event);
                }catch (Exception ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }
            throw new RuntimeException("participant not found");
        }
        throw new RuntimeException("Event not found");
    }

    @Override
    public List<Event> listUpcomingEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event findEventById(int eventId) {
        return eventRepository.findById(eventId);
    }
}
