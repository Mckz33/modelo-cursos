package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Aluno;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import com.mckz.modelocursos.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * Metodo para retornar uma lista de produtos.
     *
     * @return Lista de produtos.
     */
    public Page<Aluno> findAll(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    /**
     * Método que busca um aluno por id.
     *
     * @param id para buscar o aluno.
     * @return um optional de aluno.
     */
    public Optional<Aluno> findById(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isEmpty()) {
            throw new ResourceNotFoundException("Aluno não encontrado");
        }
        return optionalAluno;
    }

    /**
     * Metodo para adicionar um aluno a lista.
     *
     * @param aluno a ser adicionado.
     * @return retorna o aluno que foi adicionado a lista.
     */
    @Transactional
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    /**
     * Metodo que deleta um aluno
     *
     * @param aluno que será deletado
     */
    @Transactional
    public void delete(Aluno aluno) {
        alunoRepository.delete(aluno);
    }
}
