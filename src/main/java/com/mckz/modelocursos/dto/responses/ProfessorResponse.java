package com.mckz.modelocursos.dto.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProfessorResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    private Integer cpf;

    private Integer matricula;


}

