package org.example.exercices;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExoTableau {
    public static void askLong()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez moi la longueur du premier tableau ");

        int longNb = sc.nextInt();
        int[]tab = generateRandomArray(longNb);

        int[]tab2 = extendArray(tab);

        System.out.println("Premier tableau : " + Arrays.toString(tab));
        System.out.println("Second tableau : " + Arrays.toString(tab2));
    }
    public static int [] generateRandomArray (int elem)
    {
        int[] tab1 = new int[elem];

        for (int i = 0; i < tab1.length; i++) {
            Random random= new Random();
            int nombreAleatoire = random.nextInt(50);;
            tab1[i] = nombreAleatoire;
        }
        return tab1;
    }

    public static int[] extendArray(int[] arr) {
        int length = arr.length * 2;

        int[] tab2 = new int[length];

        for (int i = 0, j = 0; i < arr.length; i++) {
            tab2[i] = arr[j];
            j++;
        }



        for(int i = length/2, j =0 ; i<length; i++, j++)
        {
            int temp = arr[j];
            temp = temp * 2;
            tab2[i] = temp;

        }

        return tab2;
    }

}
