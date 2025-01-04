package com.example.demo.Controllers;

import com.example.demo.DTO.ProfesseurDTO;
import com.example.demo.Models.Module;
import com.example.demo.Models.Professeur;
import com.example.demo.Repositories.ModuleRepository;
import com.example.demo.Services.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;
    @Autowired
    private ModuleRepository moduleRepository;

    @PostMapping
    public Professeur ajouterProfesseur(
            @RequestParam String prenom,
            @RequestParam String nom,
            @RequestParam Long moduleId
    ) {
        Professeur professeur = new Professeur();
        professeur.setPrenom(prenom);
        professeur.setNom(nom);

        // Fetch the module based on moduleId (this assumes you have a method to fetch the module)
        Optional<Module> module = moduleRepository.findById(moduleId);
        module.ifPresent(professeur::setModule);

        return professeurService.ajouterProfesseur(professeur);
    }

    @GetMapping
    public List<ProfesseurDTO> obtenirTousLesProfesseurs() {
        List<Professeur> professeurs = professeurService.obtenirTousLesProfesseurs();
        List<ProfesseurDTO> professeurDTOs = new ArrayList<>();

        for (Professeur professeur : professeurs) {
            ProfesseurDTO dto = new ProfesseurDTO(
                    professeur.getId(),
                    professeur.getNom(),
                    professeur.getPrenom(),
                    professeur.getModule() != null ? professeur.getModule().getName() : ""
            );
            professeurDTOs.add(dto);
        }

        return professeurDTOs;
    }

    @GetMapping("/{id}")
    public Optional<Professeur> obtenirProfesseurParId(@PathVariable Long id) {
        return professeurService.obtenirProfesseurParId(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerProfesseur(@PathVariable Long id) {
        professeurService.supprimerProfesseur(id);
    }

    @PutMapping("/{id}")
    public Professeur mettreAJourProfesseur(
            @PathVariable Long id,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) Long moduleId
    ) {
        Optional<Professeur> existingProfesseurOpt = professeurService.obtenirProfesseurParId(id);

        if (existingProfesseurOpt.isPresent()) {
            Professeur existingProfesseur = existingProfesseurOpt.get();

            // Update fields if provided
            if (prenom != null) {
                existingProfesseur.setPrenom(prenom);
            }
            if (nom != null) {
                existingProfesseur.setNom(nom);
            }
            if (moduleId != null) {
                Optional<Module> module = moduleRepository.findById(moduleId);
                if (module.isPresent()) {
                    existingProfesseur.setModule(module.get());
                } else {
                    // Handle invalid moduleId gracefully
                    throw new RuntimeException("Module with id " + moduleId + " not found");
                }
            }

            return professeurService.ajouterProfesseur(existingProfesseur);
        } else {
            throw new RuntimeException("Professeur with id " + id + " not found");
        }
    }

}
