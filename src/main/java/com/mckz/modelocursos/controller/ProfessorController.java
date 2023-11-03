package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.dto.requests.ProfessorRequest;
import com.mckz.modelocursos.dto.responses.ProfessorResponse;
import com.mckz.modelocursos.models.Professor;
import com.mckz.modelocursos.services.ProfessorService;
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
@RequestMapping(("/api/professor"))
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> findAll() {
        List<Professor> professores = professorService.findAll();
        List<ProfessorResponse> professorResponse = professores.stream()
                .map(p -> new ModelMapper()
                        .map(p, ProfessorResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(professorResponse);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> save(@RequestBody ProfessorRequest professorRequest) {
        Professor professor = new ModelMapper().map(professorRequest, Professor.class);
        professorService.save(professor);
        ProfessorResponse professorResponse = new ModelMapper().map(professor, ProfessorResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(professorResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> findById(@PathVariable Integer id) {
        Optional<Professor> professor = professorService.findById(id);
        ProfessorResponse professorResponse = new ModelMapper().map(professor, ProfessorResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(professorResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Optional<Professor> optionalProfessor = professorService.findById(id);
        Professor professor = new ModelMapper().map(optionalProfessor, Professor.class);
        professorService.delete(professor);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> update(@PathVariable Integer id, @RequestBody ProfessorRequest professorRequest) {
        Optional<Professor> optionalProfessor = professorService.findById(id);
        Professor professor = new ModelMapper().map(professorRequest, Professor.class);
        professor.setId(optionalProfessor.get().getId());
        professorService.save(professor);
        ProfessorResponse professorResponse = new ModelMapper().map(professor, ProfessorResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(professorResponse);
    }
}

