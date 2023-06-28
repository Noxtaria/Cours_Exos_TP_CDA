package org.example.exercices.enums;


public enum MessageType {
    A,
    B,
    C,
    D;

    MessageType message;
    Priority priority;

    public Priority getPriority(MessageType message) {
        switch (message) {
            case A:
                priority = Priority.valueOf("HIGH");
                break;

            case B:
                priority = Priority.valueOf("MEDIUM");
                break;

            case C:
            case D:
                priority = Priority.valueOf("LOW");
                break;
        }
        return priority;
    }
}

