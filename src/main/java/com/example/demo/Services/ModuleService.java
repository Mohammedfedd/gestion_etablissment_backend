package com.example.demo.Services;

import com.example.demo.Models.Module;
import com.example.demo.Repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public Module ajouterModule(Module module) {
        return moduleRepository.save(module);
    }

    public List<Module> obtenirTousLesModules() {
        return moduleRepository.findAll();
    }

    public Optional<Module> obtenirModuleParId(Long id) {
        return moduleRepository.findById(id);
    }

    public void supprimerModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
