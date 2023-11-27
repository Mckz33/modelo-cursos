package com.mckz.modelocursos.controller;

import com.mckz.modelocursos.dto.requests.AlunoRequest;
import com.mckz.modelocursos.dto.responses.AlunoResponse;
import com.mckz.modelocursos.models.Aluno;
import com.mckz.modelocursos.services.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/aluno"))
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public ResponseEntity<Page<AlunoResponse>> findAll(Pageable pageable) {
        Page<Aluno> alunos = alunoService.findAll(pageable);
        List<AlunoResponse> alunoResponses = alunos.stream()
                .map(a -> new ModelMapper().map(a, AlunoResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(new PageImpl<>(alunoResponses, alunos.getPageable(), alunos.getTotalElements()));
    }


    @PostMapping
    public ResponseEntity<AlunoResponse> save(@RequestBody AlunoRequest alunoRequest) {
        Aluno aluno = new ModelMapper().map(alunoRequest, Aluno.class);
        aluno = alunoService.save(aluno);
        AlunoResponse alunoResponse = new ModelMapper().map(aluno, AlunoResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> findById(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = alunoService.findById(id);
        AlunoResponse alunoResponse = new ModelMapper().map(alunoOptional, AlunoResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(alunoResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = alunoService.findById(id);
        Aluno aluno = new ModelMapper().map(alunoOptional, Aluno.class);
        alunoService.delete(aluno);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> update(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest) {
        Optional<Aluno> alunoOptional = alunoService.findById(id);
        Aluno aluno = new ModelMapper().map(alunoRequest, Aluno.class);
        aluno.setId_aluno(alunoOptional.get().getId_aluno());
        alunoService.save(aluno);
        AlunoResponse alunoResponse = new ModelMapper().map(aluno, AlunoResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(alunoResponse);
    }
}
