package com.mckz.modelocursos.repositories;

import com.mckz.modelocursos.models.Curso;
import com.mckz.modelocursos.models.Professor;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepository {

    List<Curso> cursos = new ArrayList<>();
    Integer ultimoId = 0;

    /**
     * Metodo para etorna uma lista de cursos.
     *
     * @return Lista de cursos.
     */
    public List<Curso> getAll() {
        return cursos;
    }

    /**
     * Metodo que retorna o cursos encontrado pelo id.
     *
     * @param id do cursos que será localizado.
     * @return Retorna um cursos caso seja encontrado.
     */
    public Optional<Curso> getId(Integer id) {
        return cursos
                .stream()
                .filter(cursos -> cursos.getId().equals(id))
                .findFirst();
    }

    /**
     * Metodo para adicionar um cursos a lista.
     *
     * @param professor a ser adicionado.
     * @return retorna o cursos que foi adicionado a lista.
     */
    public Curso create(Curso professor) {
        ultimoId++;
        professor.setId(ultimoId);
        cursos.add(professor);
        return professor;
    }


    /**
     * Metodo para deletar o cursos por ID.
     *
     * @param id do cursos a ser deletado.
     */
    public void delete(Integer id) {
        cursos.removeIf(cursos -> cursos.getId().equals(id));
    }

    /**
     * Metodo para atualizar cursos pelo id
     *
     * @param professor para atualizar a ser atualizado
     * @return retorna cursos atualizado
     */
    public Curso update(Curso professor) {
        Optional<Curso> found = getId(professor.getId());

        if (found.isEmpty()) {
            throw new ResourceNotFoundException("Curso not found");
        }
        delete(professor.getId());
        cursos.add(professor);
        return professor;
    }
}

