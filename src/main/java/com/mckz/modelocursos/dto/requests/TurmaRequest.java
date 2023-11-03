package com.mckz.modelocursos.dto.requests;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TurmaRequest implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;
    private Integer semestre;
    private Date anoInicio;
}
