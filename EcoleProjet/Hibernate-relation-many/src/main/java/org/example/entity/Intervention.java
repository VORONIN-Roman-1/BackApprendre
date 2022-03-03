package org.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "intervention")
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private LocalDateTime dateheure;
    @Column
    private Double prix;
    @Column
    private String titre;
    @Column
    private String technicien;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

    public Intervention(String titre, Double prix,   String technicien, LocalDateTime dateheure) {
        this.dateheure = dateheure;
        this.prix = prix;
        this.titre = titre;
        this.technicien = technicien;
    }

    public Intervention() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateheure() {
        return dateheure;
    }

    public void setDateheure(LocalDateTime dateheure) {
        this.dateheure = dateheure;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTechnicien() {
        return technicien;
    }

    public void setTechnicien(String technicien) {
        this.technicien = technicien;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
