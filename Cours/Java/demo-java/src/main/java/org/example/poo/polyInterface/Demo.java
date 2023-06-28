package org.example.poo.polyInterface;

public class Demo {


    public static void main() {

        ElectricCar electricCar = new ElectricCar();
        electricCar.setCouleur("blue");
        electricCar.setNbreRoue(4);
        System.out.println(electricCar);

        MotorCycle motorCycle = new MotorCycle();
        motorCycle.setNbreRoue(2);
        motorCycle.setCouleur("grey");

        PetrolCar petrolCar = new PetrolCar();
        petrolCar.setCouleur("red");
        petrolCar.setNbreRoue(4);

        Engine[] engines = {electricCar, motorCycle, petrolCar};


        for (Engine engine : engines) {

            if (engine instanceof ElectricCar) {
                ((ElectricCar) engine).drive();
            }
            if (engine instanceof MotorCycle) {
                ((MotorCycle) engine).drive();
            }
            if (engine instanceof PetrolCar) {
                System.out.println("id petrolCar " + engine.getId());
            }
        }

        Vehicle[] vehicles = {electricCar, motorCycle};
    }


}
