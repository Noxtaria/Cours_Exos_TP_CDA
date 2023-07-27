package com.example.exercice_hexagonal;

import com.example.exercice_hexagonal.adapter.ConsoleAdapter;
import com.example.exercice_hexagonal.domain.service.EventService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciceHexagonalApplication {

	public static void main(String[] args) {
		com.example.exercice_hexagonal.memory.EventRepositoryMemoryImpl eventRepository = new com.example.exercice_hexagonal.memory.EventRepositoryMemoryImpl();
		EventService eventService = new EventService(eventRepository);

		ConsoleAdapter consoleAdapter = new ConsoleAdapter(eventService);

		consoleAdapter.start();
	}

}
