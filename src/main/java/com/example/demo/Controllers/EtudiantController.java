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
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
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

    // Ajouter une note pour un étudiant dans un module
    @PostMapping("/{etudiantId}/modules/{moduleId}/notes")
    public Etudiant ajouterNote(
            @PathVariable Long etudiantId,
            @PathVariable Long moduleId,
            @RequestParam Integer note) {
        return etudiantService.ajouterNote(etudiantId, moduleId, note);
    }

    // Mettre à jour une note pour un étudiant dans un module
    @PutMapping("/{etudiantId}/modules/{moduleId}/notes")
    public Etudiant mettreAJourNote(
            @PathVariable Long etudiantId,
            @PathVariable Long moduleId,
            @RequestParam Integer nouvelleNote) {
        return etudiantService.mettreAJourNote(etudiantId, moduleId, nouvelleNote);
    }

    // Supprimer une note pour un étudiant dans un module
    @DeleteMapping("/{etudiantId}/modules/{moduleId}/notes")
    public Etudiant supprimerNote(
            @PathVariable Long etudiantId,
            @PathVariable Long moduleId) {
        return etudiantService.supprimerNote(etudiantId, moduleId);
    }
}
