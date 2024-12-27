package com.example.demo.Services;

import com.example.demo.Models.Etudiant;
import com.example.demo.Models.Module;
import com.example.demo.Repositories.EtudiantRepository;
import com.example.demo.Repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    // Ajouter un étudiant
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Obtenir tous les étudiants
    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantRepository.findAll();
    }

    // Obtenir un étudiant par ID
    public Etudiant obtenirEtudiantParId(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    // Supprimer un étudiant
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    // Ajouter une note pour un étudiant dans un module
    public Etudiant ajouterNote(Long etudiantId, Long moduleId, Integer note) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Module non trouvé"));

        etudiant.getNotes().put(module, note);
        return etudiantRepository.save(etudiant);
    }

    // Mettre à jour une note pour un étudiant dans un module
    public Etudiant mettreAJourNote(Long etudiantId, Long moduleId, Integer nouvelleNote) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Module non trouvé"));

        if (!etudiant.getNotes().containsKey(module)) {
            throw new RuntimeException("La note pour ce module n'existe pas pour cet étudiant.");
        }

        etudiant.getNotes().put(module, nouvelleNote);
        return etudiantRepository.save(etudiant);
    }

    // Supprimer une note pour un étudiant dans un module
    public Etudiant supprimerNote(Long etudiantId, Long moduleId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Module non trouvé"));

        etudiant.getNotes().remove(module);
        return etudiantRepository.save(etudiant);
    }
}
