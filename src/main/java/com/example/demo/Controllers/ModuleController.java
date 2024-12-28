package com.example.demo.Controllers;

import com.example.demo.Models.Module;
import com.example.demo.Services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin(origins = "http://10.0.2.2:8080")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping
    public Module ajouterModule(@RequestParam String name) {
        Module module = new Module();
        module.setName(name);
        return moduleService.ajouterModule(module);
    }

    @GetMapping
    public List<Module> obtenirTousLesModules() {
        return moduleService.obtenirTousLesModules();
    }

    @GetMapping("/{id}")
    public Optional<Module> obtenirModuleParId(@PathVariable Long id) {
        return moduleService.obtenirModuleParId(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerModule(@PathVariable Long id) {
        moduleService.supprimerModule(id);
    }

    @PutMapping("/{id}")
    public Module mettreAJourModule(@PathVariable Long id, @RequestParam String name) {
        Optional<Module> moduleOpt = moduleService.obtenirModuleParId(id);
        if (moduleOpt.isPresent()) {
            Module module = moduleOpt.get();
            module.setName(name);
            return moduleService.ajouterModule(module);
        } else {
            return null;
        }
    }
}
