package org.example.spi.adapter;

import org.example.entity.Event;

import java.util.Date;
import java.util.List;

public interface EventAdapterService {
    void createEvent(String title, Date date, String description);
    void registerForEvent(int eventId, int participantId);
    List<Event> listUpcomingEvents();
    Event findEventById(int eventId);
}
