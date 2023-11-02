package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Professor;
import com.mckz.modelocursos.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Professor> getAll() {
        return professorRepository.getAll();
    }

    /**
     * Metodo que retorna o professor encontrado pelo id.
     *
     * @param id do professor que será localizado.
     * @return Retorna um professor caso seja encontrado.
     */
    public Optional<Professor> getId(Integer id) {
        return professorRepository.getId(id);
    }

    /**
     * Metodo para adicionar um professor a lista.
     *
     * @param professor a ser adicionado.
     * @return retorna o professor que foi adicionado a lista.
     */
    public Professor create(Professor professor) {
        return professorRepository.create(professor);
    }

    /**
     * Metodo para deletar o professor por ID.
     *
     * @param id do professor a ser deletado.
     */
    public void delete(Integer id) {
        professorRepository.delete(id);
    }

    /**
     * Metodo para atualizar o professor.
     *
     * @param id        do professor para ser atualizado.
     * @param professor a ser atualizado.
     * @return retorna o professor atualizado.
     */
    public Professor update(Integer id, Professor professor) {
        professor.setId(id);
        return professorRepository.update(professor);
    }

}
