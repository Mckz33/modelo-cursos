package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.models.Turma;
import com.mckz.modelocursos.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/turma"))
public class TurmaController {

    @Autowired
    private TurmaService turmaService;


    @GetMapping
    public List<Turma> getAll(Turma aluno) {
        return turmaService.getAll();
    }

    @PostMapping
    public Turma create(@RequestBody Turma aluno) {
        return turmaService.create(aluno);
    }

    @GetMapping("/{id}")
    public Optional<Turma> getId(@PathVariable Integer id) {
        return turmaService.getId(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        turmaService.delete(id);
        return "Produto deletado com sucess!";
    }

    @PatchMapping("/{id}")
    public Turma update(@RequestBody Turma aluno, @PathVariable Integer id) {
        return turmaService.update(id, aluno);
    }

}