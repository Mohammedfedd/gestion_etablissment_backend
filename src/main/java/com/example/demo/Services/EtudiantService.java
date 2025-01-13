package com.example.demo.Services;

import com.example.demo.Models.Etudiant;
import com.example.demo.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant obtenirEtudiantParId(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public Etudiant mettreAJourEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}
