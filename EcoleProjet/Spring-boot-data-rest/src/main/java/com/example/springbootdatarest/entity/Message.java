package com.example.springbootdatarest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message<Lond> {
    @Id
    @GeneratedValue(strategy=
            GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String signature;
    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titre) {
        this.title = titre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String contenu) {
        this.content = contenu;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
