package com.sld.entity;


import com.mvcdemo.validation.SerialNumber;

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

    @SerialNumber
    private String serialNumber;

    @Email(message="ce n'est pas un email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

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
