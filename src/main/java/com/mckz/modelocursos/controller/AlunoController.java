package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.models.Aluno;
import com.mckz.modelocursos.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/aluno"))
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.getAll();
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.create(aluno);
    }

    @GetMapping("/{id}")
    public Optional<Aluno> getId(@PathVariable Integer id) {
        return alunoService.getId(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        alunoService.delete(id);
        return "Produto deletado com sucess!";
    }

    @PutMapping("/{id}")
    public Aluno update(@RequestBody Aluno aluno, @PathVariable Integer id) {
        return alunoService.update(id, aluno);
    }

}
