package org.example.exercices;

import java.util.Arrays;
import java.util.Scanner;

public class ExoString {


    public static void getNbMots()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez moi une phrase : ");

        String sentence = sc.nextLine();
        // \\s+ divise la chaîne donnée autour d’un espace blanc
        String[] words = sentence.split("\\s+");

        System.out.println("La phrase " + sentence + " contient " + words.length + " mots");
    }

    public static void getOccurenceLetter()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez moi un mot ");

        String word = sc.next();
        word = word.toLowerCase();

        System.out.println("Donnez moi la lettre pour connaître le nombre de fois qu'elle apparaît dans le mot ");
        char letter = sc.next().toLowerCase().charAt(0);


        int nb = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == letter)
                nb++;
        }

        System.out.printf("Il y a %d fois la lettre %s dans le mot %s", nb, letter, word);

    }


    public static void askWordAndCheckAnagramme()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez moi un mot");
        String fstWord = sc.next();

        System.out.println("Donnez moi un autre mot");
        String scdWord = sc.next();

        checkIfAnagramme(fstWord, scdWord);
    }

    public static void checkIfAnagramme(String word, String otherWord)
    {
        word = word.toLowerCase();
        otherWord = otherWord.toLowerCase();

        if(word.length() == otherWord.length())
        {
            char[] tab1 = word.toCharArray();
            char[] tab2 = otherWord.toCharArray();

            Arrays.sort(tab1);
            Arrays.sort(tab2);

            String newWord = new String(tab1);
            String newOtherWord = new String(tab2);

            if(newWord.equals(newOtherWord))
                System.out.printf("Les deux mots %s et %s sont des anagrammes", word, otherWord);
            else
                System.out.printf("Les deux mots %s et %s ne sont pas des anagrammes", word, otherWord);

        }
        else
            System.out.printf("Les deux mots %s et %s ne sont pas des anagrammes", word, otherWord
            );

    }


    public static void checkIfPalindrome()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un mot ");
        String word = sc.nextLine();
        word = word.toLowerCase();

        int i = 0;
        int longueur = word.length()-1;
        boolean same = true;

        while(i < longueur/2 && same)
        {
            same = word.charAt(i) == word.charAt(longueur - i);
            i++;
        }

        if(same)
            System.out.println("Le mot " + word + " est un palindrome");
        else
            System.out.println("Le mot " + word + " n'est pas un palindrome");
    }







}
