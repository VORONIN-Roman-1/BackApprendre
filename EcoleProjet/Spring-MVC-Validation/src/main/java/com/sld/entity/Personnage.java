package com.sld.entity;


import javax.validation.constraints.*;

public class Personnage {
    private String prenom;
    @NotNull
    @Size(min=1,message="nom obligatoire")
    private String nom;

    @Min(value=0, message="doit être suéprieur ou égal à zéro")
    @Max(value=10, message="doit être inférieur ou égal à 10")
    private int pointsDeVie; // de 1 à 10

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="CP invalide: 5 caractères alphanumériques attendus")
    private String codePostal;

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
