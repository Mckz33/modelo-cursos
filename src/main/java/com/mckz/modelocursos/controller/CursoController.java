package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.models.Curso;
import com.mckz.modelocursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/curso"))
public class CursoController {


    @Autowired
    private CursoService cursoService;


    @GetMapping
    public List<Curso> getAll(Curso curso) {
        return cursoService.getAll();
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return cursoService.create(curso);
    }

    @GetMapping("/{id}")
    public Optional<Curso> getId(@PathVariable Integer id) {
        return cursoService.getId(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        cursoService.delete(id);
        return "Produto deletado com sucess!";
    }

    @PatchMapping("/{id}")
    public Curso update(@RequestBody Curso curso, @PathVariable Integer id) {
        return cursoService.update(id, curso);
    }

}
