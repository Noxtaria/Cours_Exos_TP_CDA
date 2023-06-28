package org.example.poo.polyInterface;

public class PetrolCar extends Engine{


    public PetrolCar() {
        id = Engine.count;
    }

    @Override
    void demo() {

    }

    @Override
    public String toString() {
        return "PetrolCar{" +
                "id=" + id +
                ", nbreRoue=" + nbreRoue +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
