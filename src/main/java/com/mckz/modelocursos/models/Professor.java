package com.mckz.modelocursos.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "professor")
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer cpf;
    @Column(nullable = false)
    private Integer matricula;

//    private Turma turma;

}
