package org.example.string;


import java.util.Arrays;

public class ChaineCaractere {

    public static void getFormationString(){
        System.out.println("-----Chaine de caractère---------");
        System.out.println();

        String s = "hello";

        System.out.println("s.length() " + s.length());
        System.out.println("s.contains(\"ne\") " + s.contains("ne")); //true
        System.out.println("s.isEmpty : " + s.isEmpty());
        System.out.println("s.toUppercase : " + s.toUpperCase()); //HELLO
        System.out.println("s.startsWith(\"h\") " + s.startsWith("h"));
        System.out.println("s.endsWith : " + s.endsWith("o"));

        System.out.println("s.replace() : " + s.replace("ll", "LL"));
        System.out.println("s.trim() " + s.trim());
        System.out.println("s.substring() " + s.substring(0,3));
        System.out.println("s.chartAt(1) " + s.charAt(1));
        System.out.println("Arrays.toString(s.split(\"e\")) " + Arrays.toString(s.split("e")));
        System.out.println(s);
    }


    public static void getComparaisonString(){

        System.out.println(" ---- Comparaison String ----  ");
        System.out.println();

        String s1 = "hello";
        String s2 = "hello";

        System.out.println("s1 == s2 " + (s1 == s2));


        String s3 = new String("hello");

        System.out.println("s1 == s3 " + (s1 == s3));

        System.out.println("s1 == s3 " + (s1.equals(s3)));

        String firstName = "Karim";
        String firstName1 = "karim";

        System.out.println("firstName.equals(firstName1) " + firstName.equals(firstName1));
        System.out.println("firstName.equals(firstName1) " + firstName.equalsIgnoreCase(firstName1));

    }


    public static void getFormat(){
        System.out.println(" ---- Format String ----  ");
        System.out.println();

        String nom = "Karim";

        String phrase = "Salut, cher %s, Good %s !";

        String morning = "Morning";
        String evening = "Evening";
        String afternoon = "Afternoom";

        String nouvellePhrase = String.format(phrase, nom, afternoon);

        System.out.println(nouvellePhrase);

        System.out.printf("Vous allez gagner %s millions dans %d années", 10, 5);




    }




}
