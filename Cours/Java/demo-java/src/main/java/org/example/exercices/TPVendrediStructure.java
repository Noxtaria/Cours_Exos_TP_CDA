package org.example.exercices;

import java.util.Arrays;
import java.util.Scanner;

public class TPVendrediStructure {

    public static void exo1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un nombre entier: ");
        int nombre = scanner.nextInt();

        if (nombre % 2 == 0) {
            System.out.println("Le nombre est pair");
        } else {
            System.out.println("Le nombre est impair");
        }
    }
    public static void exo2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une température en degrés Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println("La température en degrés Fahrenheit est " + fahrenheit);
    }


    public static void exo3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères: ");
        String chaine = scanner.nextLine();
        int count = 0;

        for (int i = 0; i < chaine.length(); i++) {
            if (chaine.charAt(i) != ' ') {
                count++;
            }
        }

        System.out.println("Le nombre de caractères dans la chaîne est " + count);
    }


    public static void exo5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double somme = 0;
        int count = 0;

        System.out.print("Entrez un nombre réel positif: ");
        double nombre = scanner.nextDouble();

        while (nombre >= 0) {
            somme += nombre;
            count++;
            System.out.print("Entrez un autre nombre réel positif (ou un nombre négatif pour terminer): ");
            nombre = scanner.nextDouble();
        }

        if (count == 0) {
            System.out.println("Vous n'avez entré aucun nombre positif.");
        } else {
            double moyenne = somme / count;
            System.out.println("La moyenne des nombres entrés est " + moyenne);
        }
    }

    private void exercice3() {
        boolean isRegulier1 = false;
        boolean isRegulier2 = false;
        boolean isDimension = false;
        boolean creationPossible = false;
        int longueur = 0;
        int[][] t1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 5, 7, 8 } };
        int[][] t2 = { { 5, 6, 8, 9 }, { 1, 5, 8, 7 }, { 1, 2, 8, 9 } };
        int[][] t3 = new int[t1.length][4];
        System.out.println("Tester le tableau t1?");
        System.out.println("Reponse : 1 - OK         2 - KO");
        Scanner s = new Scanner(System.in);
        if (s.nextInt() == 1) {
            isRegulier1 = isRegulierTab(t1);
        }
        System.out.println("Tester le tableau t2?");
        System.out.println("Reponse : 1 - OK         2 - KO");
        Scanner s2 = new Scanner(System.in);
        if (s2.nextInt() == 1) {
            isRegulier2 = isRegulierTab(t2);
        }

        if (t1.length == t2.length) {
            isDimension = true;
        }

        if (isDimension == true && isRegulier1 == true && isRegulier2 == true) {
            creationPossible = true;
            for (int i = 0; i < t3.length; i++) {
                for (int j = 0; j < t3[i].length; j++) {
                    t3[i][j] = t1[i][j] + t2[i][j];
                }
            }
        }
        if (creationPossible == true) {
            System.out.println("");
            System.out.println("Les tableaux sont réguliers et de même dimension.");
            System.out.println("");
            System.out.println("Le tableau t1 :");
            System.out.println("");
            afficheTab(t1);
            System.out.println("");
            System.out.println("Le tableau t2 :");
            System.out.println("");
            afficheTab(t2);
            System.out.println("");
            System.out.println("La somme des 2 tableaux dans un autre tableau :");
            System.out.println("");
            afficheTab(t3);

        } else {
            System.out.println("Les tableaux ne sont pas réguliers ou pas de même dimension.");
        }

    }


    private void exercice4() {
        int[][] tab = { { 3, 16, 9, 22, 15 }, { 20, 8, 21, 14, 2 }, { 7, 25, 13, 1, 19 }, { 24, 12, 5, 18, 6 },
                { 11, 4, 17, 10, 23 } };
        boolean magique = true;
        int sommeTest = 0;
        int sommeC = 0;
        int sommeL = 0;
        int sommeD = 0;
        System.out.println("Le tableau testé :");
        System.out.println("");
        afficheTab(tab);
        System.out.println("");
        for (int i = 0; i < tab[0].length; i++) {
            sommeTest = sommeTest + tab[0][i];
        }
        for (int i = 0; i < tab.length; i++) {
            sommeC = 0;
            sommeL = 0;
            for (int j = 0; j < tab[i].length; j++) {
                if (i == j) {
                    sommeD = sommeD + tab[i][j];
                }
                sommeC = sommeC + tab[j][i];
                sommeL = sommeL + tab[i][j];
            }
            if (sommeC != sommeTest || sommeL != sommeTest) {
                magique = false;
            }
        }
        if (sommeD != sommeTest) {
            magique = false;
        }
        if (magique == true) {
            System.out.println("La carré est magique.");
        } else {
            System.out.println("Le carré n'est pas magique.");
        }
    }


    private static void afficheTab(int[][] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print("[" + tableau[i][j] + "]");
            }
            System.out.println("");
        }
    }
    private static boolean isRegulierTab(int[][] tab) {
        boolean isRegulier = true;
        for (int i = 0; i < tab[i].length - 2; i++) {
            if (tab[i].length != tab[i + 1].length) {
                isRegulier = false;
            }
        }
        return isRegulier;

    }




}
