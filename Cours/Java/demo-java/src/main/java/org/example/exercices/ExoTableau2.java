package org.example.exercices;

import java.util.Arrays;
import java.util.Scanner;

public class ExoTableau2 {


    private static int[] tab = { 12, 1, 45, 89, 16, 35, 98, 12 };
    private static int[] tab2 = { 1, 2, 5, 9, 12, 45, 89, 100 };
    public static void exoOccurence() {
        System.out.println("Le tableau :");
        afficheTab(tab);
        int nombre = 0;
        int occurence = 0;
        System.out.println("");
        System.out.println("Merci de saisir le nombre à vérifier?");
        Scanner s = new Scanner(System.in);
        nombre = s.nextInt();
        for (int i = 0; i <= tab.length - 1; i++) {
            if (nombre == tab[i]) {
                occurence++;
            }
        }
        System.out.println("");
        System.out.println("Le nombre" + " " + nombre + " " + "est présent" + " " + occurence + " " + "fois.");
    }


    public static void verificationCroissantTab() {
        boolean trie = true;
        for (int i = 0; i <= tab2.length - 2; i++) {
            if (tab2[i] > tab2[i + 1]) {
                trie = false;
                i = tab2.length - 2;
            }
        }
        if (trie == true) {
            System.out.println("Le tableau trié de maniere croissante.");
        } else {
            System.out.println("Le tableau n'est pas trié de manière croissante.");
        }

    }

    public static void exoInversionTab() {
        System.out.println("Le tableau :");
        afficheTab(tab2);
        int i = 0;
        int j = tab2.length - 1;
        int temp = 0;
        while (i < j) {
            temp = tab2[i];
            tab2[i] = tab2[j];
            tab2[j] = temp;
            i++;
            j--;
        }
        System.out.println("");
        System.out.println("Le tableau inversé:");
        afficheTab(tab2);
    }
    private static void afficheTab(int[] tableau) {
        System.out.println(Arrays.toString(tableau));
    }

}
