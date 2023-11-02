package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.models.Professor;
import com.mckz.modelocursos.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/professor"))
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @GetMapping
    public List<Professor> getAll(Professor professor) {
        return professorService.getAll();
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return professorService.create(professor);
    }

    @GetMapping("/{id}")
    public Optional<Professor> getId(@PathVariable Integer id) {
        return professorService.getId(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        professorService.delete(id);
        return "Produto deletado com sucess!";
    }

    @PatchMapping("/{id}")
    public Professor update(@RequestBody Professor professor, @PathVariable Integer id) {
        return professorService.update(id, professor);
    }

}

