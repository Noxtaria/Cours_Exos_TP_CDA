package org.example.model;

public class Departement {
    private int id;
    private String name;

    public Departement() {
    }

    public Departement(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Departement(String name) {
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

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
