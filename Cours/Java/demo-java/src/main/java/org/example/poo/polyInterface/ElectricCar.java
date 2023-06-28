package org.example.poo.polyInterface;

public class ElectricCar extends Engine implements Vehicle, Vehicle2{

    public ElectricCar(){
        id = count;
    }
    @Override
    public void drive() {
        System.out.println("ElectricCar Drive");
    }

    @Override
    public void startEngine() {
        System.out.println("Engine is started");
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "id=" + id +
                ", nbreRoue=" + nbreRoue +
                ", couleur='" + couleur + '\'' +
                '}';
    }

    @Override
    void demo() {

    }

    @Override
    public void toto() {

    }
}
