package org.example.entity;

import javax.persistence.*;

@Entity
public class Moteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int puissance;
    @Column
    private String carburant;
    @Column
    private int cylindree;
    //двусторонная привязка
    @OneToOne(mappedBy = "moteur", cascade = CascadeType.ALL)
    private Voiture voiture;

    public Moteur() {
    }

    public Moteur(int puissance, String carburant, int cylindree) {
        this.puissance = puissance;
        this.carburant = carburant;
        this.cylindree = cylindree;
    }

    //getters() & setters()
    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }
}