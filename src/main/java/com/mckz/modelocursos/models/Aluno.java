package com.mckz.modelocursos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer cpf;
    @Column(nullable = false)
    private Integer matricula;

//    private Turma turma;

}