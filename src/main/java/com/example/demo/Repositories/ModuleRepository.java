package com.example.demo.Repositories;

import com.example.demo.Models.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findAll();
    List<Module> findByNiveau(String niveau);
}
