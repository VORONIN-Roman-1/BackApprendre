package org.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "intervention_id")
    private List<Operation> operations;

    @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(
            name="intervention_mecanicien",
            joinColumns=@JoinColumn(name="intervention_id"),
            inverseJoinColumns=@JoinColumn(name="mecanicien_id")
    )
    private List<Mecanicien> mecaniciens;

    public void add(Operation o) {
        if(operations ==null) operations=new ArrayList<>();
        operations.add(o);
    }
    public void add(Mecanicien o) {
        if(mecaniciens ==null) mecaniciens=new ArrayList<>();
        mecaniciens.add(o);
    }
    public Intervention(String titre, Double prix, String technicien, LocalDateTime dateheure) {
        this.dateheure = dateheure;
        this.prix = prix;
        this.titre = titre;
        this.technicien = technicien;
    }

    public Intervention() {
    }

    public List<Mecanicien> getMecaniciens() {
        return mecaniciens;
    }

    public void setMecaniciens(List<Mecanicien> mecaniciens) {
        this.mecaniciens = mecaniciens;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
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
