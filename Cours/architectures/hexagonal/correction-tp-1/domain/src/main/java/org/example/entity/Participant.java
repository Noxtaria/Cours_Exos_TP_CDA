package org.example.entity;

public class Participant {
    private int id;
    private String name;

    public Participant(String name) {
        this.name = name;
    }

    public Participant(int id, String name) {
        this(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
