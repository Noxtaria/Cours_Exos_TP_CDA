package com.example.exercice_hexagonal.domain.entities;

import java.util.List;

public class Event {
    private int eventId;
    private String title;
    private String date;
    private String description;
    private List<Participant> participants;

    public Event(int eventId, String title, String date, String description, List<Participant> participants) {
        this.eventId = eventId;
        this.title = title;
        this.date = date;
        this.description = description;
        this.participants = participants;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
