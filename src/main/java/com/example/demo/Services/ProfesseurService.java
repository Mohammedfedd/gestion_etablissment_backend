package com.example.demo.Services;

import com.example.demo.Models.Professeur;
import com.example.demo.Repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    public Professeur ajouterProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public List<Professeur> obtenirTousLesProfesseurs() {
        return professeurRepository.findAll();
    }

    public Optional<Professeur> obtenirProfesseurParId(Long id) {
        return professeurRepository.findById(id);
    }

    public void supprimerProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }
}
