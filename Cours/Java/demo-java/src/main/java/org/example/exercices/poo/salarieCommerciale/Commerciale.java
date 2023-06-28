package org.example.exercices.poo.salarieCommerciale;

public class Commerciale extends Salarie{

    int chiffreAffaire;
    int commission;

    int distanceParcourue = 0;

    public Commerciale(String nom, int salaire) {
        super(nom, salaire);
    }

    public Commerciale(String nom, int salaire, int chiffreAffaire, int commission) {
        super(nom, salaire);
        this.chiffreAffaire = chiffreAffaire;
        this.commission = commission;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(int chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public int getCommission() {
        return commission;
    }

    public int getDistanceParcourue() {
        return distanceParcourue;
    }

    public void setDistanceParcourue(int distanceParcourue) {
        this.distanceParcourue = distanceParcourue;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public double calculerSalaire()
    {
        int newSalaire;
        newSalaire = salaire + (commission*chiffreAffaire / 100);
        return newSalaire;
    }

    public void seDeplacer()
    {
        distanceParcourue += 1000;
    }

    public void afficherSalaireCom()
    {
        System.out.println("Le salaire avec commission de " + nom + " est de " + calculerSalaire() + " euros");
    }

    @Override
    public String toString() {
        return "Je suis un commerciale";
    }




}
