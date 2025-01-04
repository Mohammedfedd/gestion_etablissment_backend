package com.example.demo.Controllers;

import com.example.demo.Models.Personnel;
import com.example.demo.Services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @PostMapping
    public Personnel ajouterPersonnel(@RequestBody Personnel personnel) {
        return personnelService.ajouterPersonnel(personnel);
    }

    @GetMapping
    public List<Personnel> obtenirTousLesPersonnel() {
        return personnelService.obtenirTousLesPersonnel();
    }

    @GetMapping("/{id}")
    public Optional<Personnel> obtenirPersonnelParId(@PathVariable Long id) {
        return personnelService.obtenirPersonnelParId(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerPersonnel(@PathVariable Long id) {
        personnelService.supprimerPersonnel(id);
    }

    @PutMapping("/{id}")
    public Personnel mettreAJourPersonnel(
            @PathVariable Long id,
            @RequestParam String prenom,
            @RequestParam String nom,
            @RequestParam String occupation
    ) {
        Optional<Personnel> personnelOpt = personnelService.obtenirPersonnelParId(id);
        if (personnelOpt.isPresent()) {
            Personnel personnel = personnelOpt.get();
            personnel.setPrenom(prenom);
            personnel.setNom(nom);
            personnel.setOccupation(occupation);
            return personnelService.ajouterPersonnel(personnel);
        } else {
            return null;
        }
    }
}
