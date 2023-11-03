package com.mckz.modelocursos.dto.requests;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CursoRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    private Date cargaHoraria;
}
