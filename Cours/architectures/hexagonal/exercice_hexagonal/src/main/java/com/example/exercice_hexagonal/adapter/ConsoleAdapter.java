package com.example.exercice_hexagonal.adapter;

import com.example.exercice_hexagonal.domain.entities.Event;
import com.example.exercice_hexagonal.domain.service.EventService;

import java.util.List;
import java.util.Scanner;

public class ConsoleAdapter {
    private EventService eventService;
    private Scanner scanner;

    public ConsoleAdapter(EventService eventService) {
        this.eventService = eventService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    registerForEvent();
                    break;
                case 3:
                    listUpcomingEvents();
                    break;
                case 4:
                    findEventById();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Option Invalide");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Event Manager =====");
        System.out.println("1. Créer un Event");
        System.out.println("2. S'enregistrer pour un Event");
        System.out.println("3. Liste des Events");
        System.out.println("4. Rechercher l'Event par son ID");
        System.out.println("5. Quitter");
        System.out.print("Selectionner une option : ");
    }

    private void createEvent() {
        System.out.print("Veuillez saisir le titre de l'event ");
        String title = scanner.nextLine();

        System.out.print("Veuillez saisir la date de l'event ");
        String date = scanner.nextLine();

        System.out.print("Veuillez saisir la description de l'event : ");
        String description = scanner.nextLine();

        eventService.createEvent(title, date, description);

        System.out.println("L'Event vient d'être créé avec succès !");
    }

    private void registerForEvent() {
        System.out.print("Veuillez entrer l'ID de l'Event: ");
        int eventId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Veuillez entrer l'ID du participant : ");
        int participantId = scanner.nextInt();
        scanner.nextLine();

        eventService.registerForEvent(eventId, participantId);

        System.out.println("Le participant vient d'être inscrit pour cet event !");
    }

    private void listUpcomingEvents() {
        List<Event> upcomingEvents = eventService.listUpcomingEvents();

        if (upcomingEvents.isEmpty()) {
            System.out.println("Aucun Event a été trouvé.");
        } else {
            System.out.println("\nUpcoming Events:");
            for (Event event : upcomingEvents) {
                System.out.println("ID: " + event.getEventId());
                System.out.println("Title: " + event.getTitle());
                System.out.println("Date: " + event.getDate());
                System.out.println("Description: " + event.getDescription());
                System.out.println("--------------------------");
            }
        }
    }

    private void findEventById() {
        System.out.print("Veuillez entrer l'ID de l'Event ");
        int eventId = scanner.nextInt();
        scanner.nextLine();

        Event event = eventService.findEventById(eventId);

        if (event != null) {
            System.out.println("\nEvent Details:");
            System.out.println("ID: " + event.getEventId());
            System.out.println("Title: " + event.getTitle());
            System.out.println("Date: " + event.getDate());
            System.out.println("Description: " + event.getDescription());
        } else {
            System.out.println("Event non trouvé.");
        }
    }
}
