package org.example.service;

import com.example.infrastructure.InfrastructureApplication;
import com.example.infrastructure.repository.impl.EventRepositoryImpl;
import com.example.infrastructure.repository.impl.ParticipantRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(InfrastructureApplication.class, args);
        ApplicationContext context2 = SpringApplication.run(InfrastructureApplication.class, args);
        ConsoleAdapterService consoleAdapterService = new ConsoleAdapterService(new EventServiceImpl(context.getBean(EventRepositoryImpl.class),context.getBean(ParticipantRepositoryImpl.class)));
        consoleAdapterService.createEvent();

    }
}
