package com.projetweb.topevent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "participant")
public class Participant {
    private @Id String id;
    private String nom;
    private String prenom;
    private Instant bday;
    private String email;

    public Participant() {
    }

    public Participant(String id, String nom, String prenom, Instant bday, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.bday = bday;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Instant getBday() {
        return bday;
    }

    public void setBday(Instant bday) {
        this.bday = bday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
