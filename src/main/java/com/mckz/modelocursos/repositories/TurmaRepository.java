package com.mckz.modelocursos.repositories;

import com.mckz.modelocursos.models.Turma;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class TurmaRepository {


    List<Turma> turmas = new ArrayList<>();
    Integer ultimoId = 0;

    /**
     * Metodo para etorna uma lista de turmas.
     *
     * @return Lista de turmas.
     */
    public List<Turma> getAll() {
        return turmas;
    }

    /**
     * Metodo que retorna o turmas encontrado pelo id.
     *
     * @param id do turmas que será localizado.
     * @return Retorna um turmas caso seja encontrado.
     */
    public Optional<Turma> getId(Integer id) {
        return turmas
                .stream()
                .filter(turmas -> turmas.getId().equals(id))
                .findFirst();
    }

    /**
     * Metodo para adicionar um turmas a lista.
     *
     * @param professor a ser adicionado.
     * @return retorna o turmas que foi adicionado a lista.
     */
    public Turma create(Turma professor) {
        ultimoId++;
        professor.setId(ultimoId);
        turmas.add(professor);
        return professor;
    }


    /**
     * Metodo para deletar o turmas por ID.
     *
     * @param id do turmas a ser deletado.
     */
    public void delete(Integer id) {
        turmas.removeIf(turmas -> turmas.getId().equals(id));
    }

    /**
     * Metodo para atualizar turmas pelo id
     *
     * @param professor para atualizar a ser atualizado
     * @return retorna turmas atualizado
     */
    public Turma update(Turma professor) {
        Optional<Turma> found = getId(professor.getId());

        if (found.isEmpty()) {
            throw new ResourceNotFoundException("Turma not found");
        }
        delete(professor.getId());
        turmas.add(professor);
        return professor;
    }
}


