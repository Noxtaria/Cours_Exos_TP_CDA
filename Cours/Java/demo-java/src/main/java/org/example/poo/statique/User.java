package org.example.poo.statique;

public class User {

    public final int MAJORITE_USER = 18;

    private static int counter = 0;

    private int id;

    private String name;

    {
        ++counter;
    }

    public User() {
        this.id = counter;
    }

    public int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        User.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
