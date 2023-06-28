package org.example.structure;

public class Structure {

    static int montant = 100;
    static int montant2 = 200;

    public static void getIfElse() {
        if (montant > montant2) {
            System.out.println("Le montant est superieur");
        } else {
            System.out.println("Le montant est inferieur");
        }
    }


    public static void getIfElseIfElse() {
        if (montant > montant2) {
            System.out.println("Le montant est superieur");
        } else if (montant == montant2) {
            System.out.println("Le montant est egal");
        } else if (montant < montant2) {
            System.out.println("Le montant est inferieur");
        } else {
            System.out.println("code mort");
        }
    }


    public static void getSwitch(){
        String valeur = "toto";
        switch (valeur){
            case "titi":
                System.out.println("C'est titi");
                break;
            case "toto":
                System.out.println("C'est toto");
                break;
            case "tata":
                System.out.println("C'est tata");
                break;
            case "tutu":
                System.out.println("C'est tutu");
                break;
            default :
                System.out.println("C'est default");
                break;
        }




    }


}
