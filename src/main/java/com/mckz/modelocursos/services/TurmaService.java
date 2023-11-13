package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Turma;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import com.mckz.modelocursos.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    /**
     * Metodo para etorna uma lista de turmas.
     *
     * @return Lista de turmas.
     */
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    /**
     * Metodo que retorna o professor encontrado pelo id.
     *
     * @param id do professor que será localizado.
     * @return Retorna um professor caso seja encontrado.
     */
    public Optional<Turma> findById(Long id) {
        Optional<Turma> optionalTurma = turmaRepository.findById(id);
        if (optionalTurma.isEmpty()) {
            throw new ResourceNotFoundException("Turma não encontrada.");
        }
        return optionalTurma;
    }

    /**
     * Metodo para adicionar um professor a lista.
     *
     * @param turma a ser adicionado.
     * @return retorna o professor que foi adicionado a lista.
     */
    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    /**
     * Metodo para deletar o professor por ID.
     *
     * @param turma do professor a ser deletado.
     */
    public void delete(Turma turma) {
        turmaRepository.delete(turma);
    }


}
