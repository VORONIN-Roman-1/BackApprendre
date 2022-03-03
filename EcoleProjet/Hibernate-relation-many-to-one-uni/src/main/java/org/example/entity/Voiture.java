package org.example.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id ;
    @Column(name="modele")
    private String modele;
    private String immatriculation;
    @OneToOne(cascade=CascadeType.ALL) //CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE
    @JoinColumn(name="moteur_id")
    private Moteur moteur;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="voiture" ,

            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Intervention> interventions;

    public Voiture() {
    }

    public Voiture(String modele, String immatriculation) {
        this.modele = modele;
        this.immatriculation = immatriculation;
    }
    public void add (Intervention intervention) {
        if(interventions == null ){
            interventions = new ArrayList<>();
        }
        interventions.add(intervention);
        intervention.setVoiture(this);
    }
    //getters & setters
    public List<Intervention> getInterventions() {
        return interventions;
    }
    public void setInterventions(List<Intervention> interventions) {
        this.interventions = interventions;
    }
    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public Long getId() {
        return id;
    } public void setId(Long id) {
        this.id = id;
    } public String getModele() {
        return modele;
    } public void setModele(String modele) {
        this.modele = modele;
    } public String getImmatriculation() {
        return immatriculation;
    } public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    @Override
    public String toString() {
        return "Voiture [id=" + id + ", modele="
                + modele + ", immat=" + immatriculation + "]";
    }
}