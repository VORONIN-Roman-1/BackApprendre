package org.example.entity;

import javax.persistence.*;

@Entity
public class Operation {
    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String libelle;
    @Column
    private char categorie;
    @Column
    private boolean securitaire;

    public Operation() {
    }

    public Operation(String libelle, char categorie, boolean securitaire) {
        this.libelle = libelle;
        this.categorie = categorie;
        this.securitaire = securitaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public char getCategorie() {
        return categorie;
    }

    public void setCategorie(char categorie) {
        this.categorie = categorie;
    }

    public boolean isSecuritaire() {
        return securitaire;
    }

    public void setSecuritaire(boolean securitaire) {
        this.securitaire = securitaire;
    }
}
