package com.projetweb.topevent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "events")
public class Event {

    private @Id String id;
    private String name;
    private long idOrganisateur;
    private Instant date;
    private String lieux;
    private double prix;
    private String description;
    private String imageURL;
    private List<String> participants;

    public Event() {}

    public Event(String id, String name, long idOrganisateur, Instant date, String lieux, double prix, String description, String imageURL, List<String> participants) {
        this.id = id;
        this.name = name;
        this.idOrganisateur = idOrganisateur;
        this.date = date;
        this.lieux = lieux;
        this.prix = prix;
        this.description = description;
        this.imageURL = imageURL;
        this.participants = participants;
    }

    public Event(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setIdOrganisateur(long idOrganisateur) {
        this.idOrganisateur = idOrganisateur;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public long getIdOrganisateur() {
        return idOrganisateur;
    }
}
