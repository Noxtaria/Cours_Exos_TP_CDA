package org.example.structure;

public class Structure2 {

    public static void getBoucleFor(){
        int[] tab = {1,5,9,7};
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            System.out.println("valeur i " + i);
        }

        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("compteur i : " + i + "compteur j : " + j );
        }

        for (int number:tab) {
            sum += number;
            System.out.println("number est egal à : " + number);
        }

        System.out.println("La somme de mon tableau est de : " + sum);

    }

    public static void getBreakAndContinue(){

       /* System.out.println("---- continue ------");
        for (int i = 0; i < 5; i++) {
            if(i % 2 == 1 ){
                System.out.println("Je suis dans le if " + i);
                continue;
            }
            System.out.println("counter : " + i);
        }

        System.out.println("---- Break ------");

        for (int i = 0; i <= 5; i++) {
            if(i == 3){
                break;
            }
            System.out.println("counter : " + i);

        }*/
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 ; j++) {
                if(j == 3){
                   break;
                }
                System.out.println(j + " ");
            }
            System.out.println("counter : " + i);
        }


    }




}
