package org.example.spi.port;

import org.example.entity.Participant;

public interface ParticipantRepository {
    void save(Participant participant);
    Participant findById(int participantId);
}
