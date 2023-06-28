package org.example.exercices;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExoMatrice {


    int[][] tabVoiture = new int[5][5];
    private void matrice1() {
        int[][] tab = new int[12][8];
        Random r = new Random();
        int max = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = r.nextInt(96);
            }
        }
        System.out.println("Le tableau :");
        System.out.println("");
        afficheTab(tab);
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (i == 0 && j == 0) {
                    max = tab[i][j];
                }
                if (tab[i][j] > max) {
                    max = tab[i][j];
                }
            }
        }
        System.out.println("");
        System.out.println("Le nombre le plus grand du tableau à deux dimension(12,8) est" + " " + max);
    }



    private void matrice2() {
        int[][] tab = new int[10][4];
        int valeur = 0;
        int moyenne = 0;
        int produit = 1;
        int somme = 0;
        Random r = new Random();
        System.out.println("Merci de saisir une valeur entre 5 et 100 ");
        Scanner s = new Scanner(System.in);
        System.out.print("Reponse : ");
        valeur = s.nextInt();
        System.out.println(" ");
        for (int i = 0; i <= tab.length - 1; i++) {
            for (int j = 0; j <= tab[i].length - 1; j++) {
                tab[i][j] = r.nextInt(valeur) + 1;
                somme = somme + tab[i][j];
                produit = produit * tab[i][j];
            }
        }
        afficheTab(tab);
        System.out.println(" ");
        moyenne = somme / (10 * 4);
        System.out.println("La somme est de" + " " + somme + " " + ",le produit est de " + " " + produit + " "
                + "et enfin, la moyenne est de" + " " + moyenne);

    }

    private void voitureMatrice() {

        for (int i = 0; i <= tabVoiture.length - 1; i++) {
            for (int j = 0; j <= tabVoiture[i].length - 1; j++) {

                if (i == 0 && j > 0) {
                    System.out.println("Merci de saisir le numero du vendeur" + " " + j + 1 + ":");
                    Scanner s = new Scanner(System.in);
                    tabVoiture[i][j] = s.nextInt();
                }
                if (j == 0 && i > 0) {
                    System.out.println("Merci de saisir le numero du modele" + " " + i + 1 + ":");
                    Scanner s = new Scanner(System.in);
                    tabVoiture[i][j] = s.nextInt();
                }
            }
        }
        System.out.println("Le tableau :");
        System.out.println("");
        afficheTab(tabVoiture);
        for (int i = 1; i <= tabVoiture.length - 1; i++) {
            for (int j = 1; j < tabVoiture[i].length; j++) {
                System.out.println("Merci de remplir les ventes pour le véhicule n°" + " " + tabVoiture[i][0] + " "
                        + "et le vendeur n°" + " " + tabVoiture[0][j]);
                Scanner s = new Scanner(System.in);
                tabVoiture[i][j] = s.nextInt();
            }
            System.out.println("");
            afficheTab(tabVoiture);
            System.out.println("");
        }
    }


    private void afficheTab(int[][] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print("[" + tableau[i][j] + "]");
            }
            System.out.println("");
        }
    }
}
