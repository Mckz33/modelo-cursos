package com.mckz.modelocursos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_aluno;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer cpf;
    @Column(nullable = false)
    private Integer matricula;

    @ManyToOne
    @JoinColumn(name = "id")
    private Turma turma;

    @ManyToMany
    @JoinTable(name = "matricula",
    joinColumns = {@JoinColumn(name = "id_aluno")},
    inverseJoinColumns = {@JoinColumn(name = "id_curso")})
    private List<Curso> cursos;

}