package com.tld.entity;

import java.util.LinkedHashMap;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String pays;
    private String osPrefere;
    private String[] competences;

    public String[] getCompetences() {
        return competences;
    }

    public void setCompetences(String[] competences) {
        this.competences = competences;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getOsPrefere() {
        return osPrefere;
    }

    public void setOsPrefere(String osPrefere) {
        this.osPrefere = osPrefere;
    }
}
