package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @ElementCollection
    @CollectionTable(name = "etudiant_notes", joinColumns = @JoinColumn(name = "etudiant_id"))
    @MapKeyJoinColumn(name = "module_id")
    @Column(name = "note")
    private Map<Module, Integer> notes = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Map<Module, Integer> getNotes() {
        return notes;
    }

    public void setNotes(Map<Module, Integer> notes) {
        this.notes = notes;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
