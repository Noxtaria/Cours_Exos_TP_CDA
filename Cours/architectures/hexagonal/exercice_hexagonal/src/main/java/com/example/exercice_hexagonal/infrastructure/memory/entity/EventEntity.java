package com.example.exercice_hexagonal.infrastructure.memory.entity;

public class EventEntity {
    private int eventId;
    private String title;
    private String date;
    private String description;

    public EventEntity(int eventId, String title, String date, String description) {
        this.eventId = eventId;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public EventEntity() {
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

    @Override
    public String toString() {
        return "EventEntity{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
