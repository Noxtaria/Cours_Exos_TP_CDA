package org.example.poo.polyInterface;

public class MotorCycle extends Engine implements Vehicle{


   public MotorCycle() {
        id = Engine.count;
    }

    @Override
    void demo() {

    }

    @Override
    public void drive() {
        System.out.println("Motor drive");

    }

    @Override
    public void startEngine() {
        System.out.println("Motor started");

    }

    @Override
    public String toString() {
        return "MotorCycle{" +
                "id=" + id +
                ", nbreRoue=" + nbreRoue +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
