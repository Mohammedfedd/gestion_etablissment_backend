package com.example.demo.Services;

import com.example.demo.Models.Module;
import com.example.demo.Models.Personnel;
import com.example.demo.Repositories.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    public Personnel ajouterPersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

    public List<Personnel> obtenirTousLesPersonnel() {
        return personnelRepository.findAll();
    }

    public Optional<Personnel> obtenirPersonnelParId(Long id) {
        return personnelRepository.findById(id);
    }

    public void supprimerPersonnel(Long id) {
        personnelRepository.deleteById(id);
    }

    public Personnel mettreAJourPersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

}
