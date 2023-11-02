package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Turma;
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
    public List<Turma> getAll() {
        return turmaRepository.getAll();
    }

    /**
     * Metodo que retorna o professor encontrado pelo id.
     *
     * @param id do professor que será localizado.
     * @return Retorna um professor caso seja encontrado.
     */
    public Optional<Turma> getId(Integer id) {
        return turmaRepository.getId(id);
    }

    /**
     * Metodo para adicionar um professor a lista.
     *
     * @param professor a ser adicionado.
     * @return retorna o professor que foi adicionado a lista.
     */
    public Turma create(Turma professor) {
        return turmaRepository.create(professor);
    }

    /**
     * Metodo para deletar o professor por ID.
     *
     * @param id do professor a ser deletado.
     */
    public void delete(Integer id) {
        turmaRepository.delete(id);
    }

    /**
     * Metodo para atualizar o professor.
     *
     * @param id        do professor para ser atualizado.
     * @param professor a ser atualizado.
     * @return retorna o professor atualizado.
     */
    public Turma update(Integer id, Turma professor) {
        professor.setId(id);
        return turmaRepository.update(professor);
    }

}
