package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.dto.requests.TurmaRequest;
import com.mckz.modelocursos.dto.responses.TurmaResponse;
import com.mckz.modelocursos.models.Turma;
import com.mckz.modelocursos.services.TurmaService;

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
@RequestMapping(("/api/turma"))
public class TurmaController {

    @Autowired
    private TurmaService turmaService;


    @GetMapping
    public ResponseEntity<List<TurmaResponse>> findAll() {
        List<Turma> turmas = turmaService.findAll();
        List<TurmaResponse> turmaResponses = turmas.stream()
                .map(t -> new ModelMapper()
                        .map(t, TurmaResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(turmaResponses);
    }

    @PostMapping
    public ResponseEntity<TurmaResponse> save(@RequestBody TurmaRequest turmaRequest) {
        Turma turma = new ModelMapper().map(turmaRequest, Turma.class);
        turmaService.save(turma);
        TurmaResponse turmaResponse = new ModelMapper().map(turma, TurmaResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(turmaResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> findById(@PathVariable Long id) {
        Optional<Turma> optionalTurma = turmaService.findById(id);
        Turma turma = new ModelMapper().map(optionalTurma, Turma.class);
        TurmaResponse turmaResponse = new ModelMapper().map(turma, TurmaResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(turmaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Turma> optionalTurma = turmaService.findById(id);
        if (optionalTurma.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        turmaService.delete(optionalTurma.get());
        return ResponseEntity.status(HttpStatus.OK).body("Turma deletada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Turma turma) {
        Optional<Turma> optionalTurma = turmaService.findById(id);
        if (optionalTurma.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Turma não encontrada");
        }
        var turmaUpdate = optionalTurma.get().getId_turma();
        turma.setId_turma(turmaUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turma));
    }
}