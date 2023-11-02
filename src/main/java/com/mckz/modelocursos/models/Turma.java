package com.mckz.modelocursos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "turma")
@Data
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private Integer semestre;
    private Date anoInicio;
}
