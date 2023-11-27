package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Professor;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import com.mckz.modelocursos.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Metodo para etorna uma lista de produtos.
     *
     * @return Lista de produtos.
     */
    public Page<Professor> findAll(Pageable pageable) {
        return professorRepository.findAll(pageable);
    }

    /**
     * Metodo que retorna o professor encontrado pelo id.
     *
     * @return Retorna um professor caso seja encontrado.
     */
    public Optional<Professor> findById(Long id) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isEmpty()) {
            throw new ResourceNotFoundException("Professor não encontrado.");
        }
        return optionalProfessor;
    }

    /**
     * Metodo para adicionar um professor a lista.
     *
     * @param professor a ser adicionado.
     * @return retorna o professor que foi adicionado a lista.
     */
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    /**
     * Metodo que remove um professor
     * @param professor que será removido
     */
    public void delete(Professor professor) {
        professorRepository.delete(professor);
    }


}
