package com.example.demo.DTO;

public class ProfesseurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String moduleName;

    // Constructor, getters, and setters
    public ProfesseurDTO(Long id, String nom, String prenom, String moduleName) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.moduleName = moduleName;
    }

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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}

