package org.example.exercices.poo.salarieCommerciale;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Demo implements Methode {

    String name;
    int salaire;
    String searchName;
    int commission;
    int chiffreAffaire;

    List<Salarie> listeSalaries = new ArrayList<>();
    Salarie salarie = new Salarie("Momo Data", 1500);
    Salarie salarie1 = new Salarie("MichMich Polo", 1800);
    Salarie salarie2 = new Salarie("Chantal Tor", 1200);
    Commerciale com = new Commerciale("Leslie Pola", 2000, 20000, 5);
    Commerciale com1 = new Commerciale("Brutus Tordu", 1200, 10200, 10);




    public void proposition() {
        listeSalaries.add(salarie);
        listeSalaries.add(salarie1);
        listeSalaries.add(salarie2);
        listeSalaries.add(com1);
        listeSalaries.add(com);
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Gestion des Employés ====");
        System.out.println();

        String[] propositions = {"1- Ajouter un employé", "2- Afficher le salaire des employés", "3- Rechercher un employé", "0- Quitter", "Entrez votre choix : "};

        for (String prop : propositions) {
            System.out.println(prop);
        }

        String answer = sc.next();

        switch (answer) {
            case "1":
                menuEmploye();
                proposition();

            case "2":
                for (Salarie s : listeSalaries) {
                    System.out.println(s);
                    s.afficherSalaire();
                    //Pour la classe Commerciale
                    if (s instanceof Commerciale) {
                        ((Commerciale) s).afficherSalaireCom();
                    }

                    System.out.println("------------------------");
                }
                proposition();

            case "3":
                System.out.println("==== Recherche Employé par Nom ====");
                System.out.println();
                System.out.println("Merci de saisir le nom : ");

                sc.nextLine();
                searchName = sc.nextLine();

                for (Salarie s : listeSalaries) {
                    if (Objects.equals(s.nom, searchName)) {
                        s.afficherSalaire();
                        if (s instanceof Commerciale) {
                            ((Commerciale) s).afficherSalaireCom();
                        }
                    }
                }
                proposition();

            case "0":
                break;

            default:
                System.out.println("Je n'ai pas compris votre demande ");
                proposition();


        }


    }


    public void menuEmploye() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Ajouter un employé ====");
        System.out.println();

        String[] propositions = {"1-- Salarié", "2-- Commerciale", "0-- Retour", "Entrez votre choix : "};

        for (String prop : propositions) {
            System.out.println(prop);
        }

        String answer = sc.next();


        switch (answer) {
            case "1":
                ajoutEmploye();
                Salarie salarie = new Salarie(name, salaire);
                listeSalaries.add(salarie);
                menuEmploye();

            case "2":
                ajoutCommerciale();
                Commerciale commerciale = new Commerciale(name, salaire, chiffreAffaire, commission);
                listeSalaries.add(commerciale);
                menuEmploye();

            case "0":
                break;

            default:
                System.out.println("Je n'ai pas compris votre demande ");
                menuEmploye();


        }
        proposition();


    }

    public void ajoutEmploye() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Merci de saisir le nom");
        name = sc.nextLine();
      //  sc.nextLine();
        System.out.println("Merci de saisir le matricule");
        String matricule = sc.next();

        System.out.println("Merci de saisir la catégorie");
        String category = sc.next();

        System.out.println("Merci de saisir le service");
        String service = sc.next();

        System.out.println("Merci de saisir le salaire");
        salaire = parseInt(sc.next());
    }

    public void ajoutCommerciale() {
        Scanner sc = new Scanner(System.in);
        ajoutEmploye();
        System.out.println("Merci de saisir le chiffre d'affaire");
        chiffreAffaire = parseInt(sc.next());

        System.out.println("Merci de saisir la commission");
        commission = parseInt(sc.next());
    }


}
