package com.example.exercice_hexagonal.domain.entities;

public class Participant {
    private int participantId;
    private String name;

    public Participant() {
    }

    public Participant(int participantId, String name) {
        this.participantId = participantId;
        this.name = name;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantId=" + participantId +
                ", name='" + name + '\'' +
                '}';
    }
}
