package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.dto.requests.CursoRequest;
import com.mckz.modelocursos.dto.responses.CursoResponse;
import com.mckz.modelocursos.models.Curso;
import com.mckz.modelocursos.services.CursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/curso"))
public class CursoController {


    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoResponse>> findAll() {
        List<Curso> cursos = cursoService.findAll();
        List<CursoResponse> cursoResponses = cursos.stream()
                .map(c -> new ModelMapper().map(c, CursoResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(cursoResponses);
    }

    @PostMapping
    public ResponseEntity<CursoResponse> save(@RequestBody CursoRequest cursoRequest) {
        Curso curso = new ModelMapper().map(cursoRequest, Curso.class);
        cursoService.save(curso);
        CursoResponse cursoResponse = new ModelMapper().map(curso, CursoResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(cursoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> findById(@PathVariable Long id) {
        Optional<Curso> optionalCurso = cursoService.findById(id);
        CursoResponse cursoResponse = new ModelMapper().map(optionalCurso, CursoResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(cursoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Curso> cursoOptional = cursoService.findById(id);
        Curso curso = new ModelMapper().map(cursoOptional, Curso.class);
        cursoService.delete(curso);
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso!");
    }

    @PutMapping("{id}")
    public ResponseEntity<CursoResponse> update(@PathVariable Long id, @RequestBody CursoRequest cursoRequest) {
        Optional<Curso> optionalCurso = cursoService.findById(id);
        Curso curso = new ModelMapper().map(cursoRequest, Curso.class);
        curso.setId_curso(optionalCurso.get().getId_curso());
        cursoService.save(curso);
        CursoResponse cursoResponse = new ModelMapper().map(curso, CursoResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(cursoResponse);
    }

}
