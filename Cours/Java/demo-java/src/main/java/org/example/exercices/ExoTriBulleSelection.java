package org.example.exercices;

import java.util.Arrays;

public class ExoTriBulleSelection {


    private static int[] tab = { 12, 1, 45, 89, 16, 35, 98, 12 };

    private static void exoTrieBulle() {
        System.out.println("Le tableau :");
        afficheTab(tab);
        int temp = 0;
        int i = 0;
        while (i <= tab.length-1) {
            for (int j = 0; j < (tab.length-1)-i; j++) {
                if (tab[j] > tab[j + 1]) {
                    temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                }
            }
            i++;
        }
        System.out.println("Le tableau avec tri à bulle :");
        afficheTab(tab);
    }


    private static void exoTrieSelection() {
        System.out.println("Le tableau :");
        afficheTab(tab);
        System.out.println("");
        System.out.println("Les etapes:");
        int min = 0;
        int indiceMin = 0;
        int indice = 0;
        int temp = 0;

        while (indice < tab.length) {

            min = tab[indice];

            for (int i = indice; i < tab.length; i++) {

                if (tab[i] < min) {
                    min = tab[i];
                    indiceMin = i;

                }
            }
            temp = tab[indice];
            tab[indice] = tab[indiceMin];
            tab[indiceMin] = temp;
            afficheTab(tab);
            indice++;

        }
        System.out.println("");
        System.out.println("Le tableau trié croissant (Selection):");
    }

    private static void afficheTab(int[] tableau) {
        System.out.println(Arrays.toString(tableau));
    }

}
