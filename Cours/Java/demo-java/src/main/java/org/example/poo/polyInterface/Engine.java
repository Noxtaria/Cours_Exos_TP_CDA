package org.example.poo.polyInterface;

public abstract class Engine {

    protected static int count = 0;
    protected int id;

    protected int nbreRoue;

    protected String couleur;

    {
        ++count;
    }


    abstract void demo();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbreRoue() {
        return nbreRoue;
    }

    public void setNbreRoue(int nbreRoue) {
        this.nbreRoue = nbreRoue;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
