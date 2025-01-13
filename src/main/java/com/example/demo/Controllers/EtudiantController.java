package com.example.demo.Controllers;

import com.example.demo.Models.Etudiant;
import com.example.demo.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    // Ajouter un étudiant
    @PostMapping
    public Etudiant ajouterEtudiant(@RequestParam String prenom, @RequestParam String nom, @RequestParam String niveau) {
        Etudiant etudiant = new Etudiant();
        etudiant.setPrenom(prenom);
        etudiant.setNom(nom);
        etudiant.setNiveau(niveau);
        return etudiantService.ajouterEtudiant(etudiant);
    }

    // Obtenir tous les étudiants
    @GetMapping
    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantService.obtenirTousLesEtudiants();
    }

    // Obtenir un étudiant par ID
    @GetMapping("/{id}")
    public Etudiant obtenirEtudiantParId(@PathVariable Long id) {
        return etudiantService.obtenirEtudiantParId(id);
    }

    // Supprimer un étudiant
    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable Long id) {
        etudiantService.supprimerEtudiant(id);
    }

    // Mettre à jour un étudiant
    @PutMapping("/{id}")
    public Etudiant mettreAJourEtudiant(
            @PathVariable Long id,
            @RequestParam String prenom,
            @RequestParam String nom,
            @RequestParam String niveau) {
        Etudiant etudiant = etudiantService.obtenirEtudiantParId(id);
        etudiant.setPrenom(prenom);
        etudiant.setNom(nom);
        etudiant.setNiveau(niveau);
        return etudiantService.mettreAJourEtudiant(etudiant);
    }
}
