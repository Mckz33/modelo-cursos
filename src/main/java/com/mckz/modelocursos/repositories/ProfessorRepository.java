package com.mckz.modelocursos.repositories;

import com.mckz.modelocursos.models.Professor;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}

