package org.example.exercices;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exo2 {

    public  void solutionExo4() {
        int nombre = 0;
        System.out.println("Merci de saisir le nombre :");
        Scanner s = new Scanner(System.in);
        nombre = s.nextInt();
        if (nombre < 0) {
            System.out.print("Le nombre" + " " + nombre + " " + "est négatif.");
        } else {
            System.out.print("Le nombre" + " " + nombre + " " + "est positif.");
        }
    }


    public static void solutionExo5() {
        int nombre1 = 0;
        int nombre2 = 0;
        System.out.println("Merci de saisir le premier nombre :");
        Scanner s = new Scanner(System.in);
        nombre1 = s.nextInt();
        System.out.println("Merci de saisir le second nombre :");
        nombre2 = s.nextInt();

        if (nombre1 < 0 ^ nombre2 < 0) {
            System.out.print("Le produit de" + " " + nombre1 + " " + "et de " + " " + nombre2 + " " + "est negatif ");
        } else {
            System.out.print("Le produit de" + " " + nombre1 + " " + "et de" + " " + nombre2 + " " + "est positif ");
        }


    }

    public static void solutionExo6() {
        String nom = " ";
        String nom2 = " ";
        String nom3 = " ";
        System.out.println("Quel est le nom 1 ?");
        Scanner s = new Scanner(System.in);
        nom = s.next();
        System.out.println("Quel est le nom 2 ?");
        nom2 = s.next();
        System.out.println("Quel est le nom 3 ?");
        nom3 = s.next();
        if (nom.compareTo(nom2) < 0 && nom2.compareTo(nom3) < 0) {
            System.out.print("Les noms" + " " + nom + ", " + nom2 + ", " + nom3 + " " + "sont rangés dans l'ordre alphabétique.");
        } else {
            System.out.print("Les noms" + " " + nom + ", " + nom2 + ", " + nom3 + " " + "ne sont pas rangés dans l'ordre alphabétique.");
        }
        s.close();
    }

    public  void solutionExo7() {
        int nombre = 0;
        System.out.println("Merci de saisir un nombre?");
        Scanner s3 = new Scanner(System.in);
        nombre = s3.nextInt();

        if (nombre == 0) {
            System.out.println("Le nombre est null");
        } else if (nombre < 0) {
            System.out.println("Le nombre est négatif");
        } else {
            System.out.println("Le nombre est positif");
        }
    }

    public static void solutionExo8() {
        int age = 0;
        System.out.println("Merci de saisir l'age de l'enfant?");
        Scanner s3 = new Scanner(System.in);
        age = s3.nextInt();
        if (age >= 12) {
            System.out.println("Il est dans la catégorie Cadet");
        } else if (age >= 10) {
            System.out.println("Il est dans la catégorie Minime");
        } else if (age >= 8) {
            System.out.println("Il est dans la catégorie Pupille");
        } else if ( age >= 6) {
            System.out.println("Il est dans la catégorie Poussin");
        }else{
            System.out.println("Aucune catégorie");
        }
    }

    public  void solutionExo9() {
        int nombre = 0;
        System.out.println("Merci de saisir un nombre entier?");
        Scanner s3 = new Scanner(System.in);
        nombre = s3.nextInt();

        if (nombre%3 == 0) {
            System.out.println("Le nombre est divisible par 3.");
        } else{
            System.out.println("Le nombre n'est pas divisible par 3.");
        }
    }

    public static void solutionExo10() {
        int nombre = 0;
        double total = 0;
        System.out.println("Merci de saisir le nombre de photocopies à réaliser ?");
        Scanner s = new Scanner(System.in);
        nombre = s.nextInt();
        if (nombre > 20) {
            total = nombre * 0.05;
        } else if (nombre <= 20 && nombre > 10) {
            total = nombre * 0.10;
        } else {
            total = nombre * 0.15;
        }
        System.out.println("Le prix à payer est de" + " " + total + " " + "euros");
    }

    public static void solutionExo10Bis(){

            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez le nombre de photocopies a effectuer");
            int nombre = sc.nextInt();

            float price = 0;
            String unites = "centimes";

            if (nombre < 10) {
                price = nombre * 15;
            } else if (nombre <= 20) {
                price = nombre * 10;
            } else {
                price = nombre * 5;
            }

            if (price >= 100){
                price = price / 100;
                unites = "euros";
            }

            DecimalFormat double_decimal = new DecimalFormat("#.##");

            System.out.printf("Vous devez payer %s %s pour vos %d photocopie(s)", double_decimal.format(price), unites, nombre);
    }

    public static void solutionExo11() {
        Integer nombre6 = 0;
        Integer resultat = 0;
        System.out.println("Donnez moi le nombre de depart?");
        Scanner s2 = new Scanner(System.in);
        nombre6 = s2.nextInt();
        System.out.println("Table de multiplication" + " " + nombre6);
        for (int i = 1; i <= 10; i++) {
            resultat = nombre6 * i;
            System.out.println(nombre6 + " " + "X" + " " + i + " " + "=" + " " + resultat);
        }
    }

    public static void solutionExo12() {
        Integer somme = 0;
        Integer nombre7 = 0;
        System.out.println("Donnez moi le nombre de depart?");
        Scanner s3 = new Scanner(System.in);
        nombre7 = s3.nextInt();
        for (int i = 0; i <= nombre7; i++) {
            somme = somme + i;
        }

        System.out.println("Somme =" + " " + somme);
    }



}
