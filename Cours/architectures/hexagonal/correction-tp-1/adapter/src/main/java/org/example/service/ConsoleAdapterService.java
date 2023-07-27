package org.example.service;

import org.example.entity.Event;
import org.example.spi.adapter.EventAdapterService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleAdapterService  {

    private Scanner scanner;

    private EventService eventService;

    public ConsoleAdapterService(EventService eventService) {
        scanner = new Scanner(System.in);
        this.eventService = eventService;
    }

    public void createEvent() {
        System.out.println("Merci de saisir le titre");
        String title = scanner.nextLine();
        //Description, date....
        eventService.createEvent(title, new Date(), "description");
    }
}
