package org.example.array;

public class ArrayClass {

    static int[][] matrice = {{1, 2, 3}, {23, 89, 45, 78}, {4, 9}};

    public static void getArray() {

        int[] tab;
        int tab2[];

        tab = new int[10];

        double[] doubles = new double[5];

        int[] tab3 = {1, 98, 78};

        //  System.out.println(tab3[1]);

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.println(matrice[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void getDoubleTab() {

        int[][] tabo = new int[3][4];

        for (int i = 0; i < tabo.length; i++) {
            for (int j = 0; j < tabo[i].length; j++) {
                tabo[i][j] = i + j;
            }
        }

        for (int i = 0; i < tabo.length; i++) {
            for (int j = 0; j < tabo[i].length; j++) {
                System.out.println(tabo[i][j] + " ");
            }
            System.out.println();
        }


    }


}
