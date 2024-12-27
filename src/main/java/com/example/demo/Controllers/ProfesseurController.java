package com.example.demo.Controllers;

import com.example.demo.Models.Professeur;
import com.example.demo.Services.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @PostMapping
    public Professeur ajouterProfesseur(@RequestBody Professeur professeur) {
        return professeurService.ajouterProfesseur(professeur);
    }

    @GetMapping
    public List<Professeur> obtenirTousLesProfesseurs() {
        return professeurService.obtenirTousLesProfesseurs();
    }

    @GetMapping("/{id}")
    public Optional<Professeur> obtenirProfesseurParId(@PathVariable Long id) {
        return professeurService.obtenirProfesseurParId(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerProfesseur(@PathVariable Long id) {
        professeurService.supprimerProfesseur(id);
    }
}
