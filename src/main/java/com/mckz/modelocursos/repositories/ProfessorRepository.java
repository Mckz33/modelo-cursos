package com.mckz.modelocursos.repositories;

import com.mckz.modelocursos.models.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfessorRepository {


    List<Professor> professores = new ArrayList<>();
    Integer ultimoId = 0;

    /**
     * Metodo para etorna uma lista de professores.
     *
     * @return Lista de professores.
     */
    public List<Professor> getAll() {
        return professores;
    }

    /**
     * Metodo que retorna o professores encontrado pelo id.
     *
     * @param id do professores que será localizado.
     * @return Retorna um professores caso seja encontrado.
     */
    public Optional<Professor> getId(Integer id) {
        return professores
                .stream()
                .filter(professores -> professores.getId().equals(id))
                .findFirst();
    }

    /**
     * Metodo para adicionar um professores a lista.
     *
     * @param professor a ser adicionado.
     * @return retorna o professores que foi adicionado a lista.
     */
    public Professor create(Professor professor) {
        ultimoId++;
        professor.setId(ultimoId);
        professores.add(professor);
        return professor;
    }


    /**
     * Metodo para deletar o professores por ID.
     *
     * @param id do professores a ser deletado.
     */
    public void delete(Integer id) {
        professores.removeIf(professores -> professores.getId().equals(id));
    }

    /**
     * Metodo para atualizar professores pelo id
     *
     * @param professor para atualizar a ser atualizado
     * @return retorna professores atualizado
     */
    public Professor update(Professor professor) {
        Optional<Professor> found = getId(professor.getId());

        if (found.isEmpty()) {
            throw new InputMismatchException("Professor not found");
        }
        delete(professor.getId());
        professores.add(professor);
        return professor;
    }
}

