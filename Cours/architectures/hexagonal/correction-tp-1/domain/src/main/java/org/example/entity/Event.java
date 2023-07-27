package org.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    private int id;
    private String title;
    private Date date;
    private String description;

    private List<Participant> participants;

    public Event(String title, Date date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        participants = new ArrayList<>();
    }

    public Event(int id, String title, Date date, String description, List<Participant> participants) {
        this(title, date, description);
        this.id = id;
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
