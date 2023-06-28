package org.example.exercices.enums;

import java.util.Scanner;

public class TestMessage {
    public static void askMessage(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Donnez moi votre type message : ");
            MessageType message = MessageType.valueOf(sc.next().toUpperCase());
            Priority priority = message.getPriority(message);
            System.out.println(message + " : " + priority);
        }catch (IllegalArgumentException e)
        {
            System.out.println("Type de message incorrect");
            askMessage();
        }
    }
}
