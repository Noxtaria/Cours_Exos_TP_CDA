package com.example.infrastructure.repository.impl;

import com.example.infrastructure.entity.ParticipantEntity;
import com.example.infrastructure.repository.ParticpantEntityRepository;
import org.example.entity.Participant;
import org.example.spi.port.ParticipantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class ParticipantRepositoryImpl implements ParticipantRepository {

    @Autowired
    private ParticpantEntityRepository particpantEntityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(Participant participant) {
        ParticipantEntity participantEntity = modelMapper.map(participant, ParticipantEntity.class);
        particpantEntityRepository.save(participantEntity);
    }

    @Override
    public Participant findById(int participantId) {
        Optional<ParticipantEntity> participantEntityOptional = particpantEntityRepository.findById(participantId);
        if(participantEntityOptional.isPresent()){
            return modelMapper.map(participantEntityOptional.get(), Participant.class);
        }
        throw new RuntimeException("Participant not found");
    }
}
