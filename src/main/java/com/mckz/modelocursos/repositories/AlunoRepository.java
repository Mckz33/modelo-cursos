package com.mckz.modelocursos.repositories;

import com.mckz.modelocursos.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
