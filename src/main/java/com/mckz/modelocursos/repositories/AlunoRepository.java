package com.mckz.modelocursos.repositories;

import com.mckz.modelocursos.models.Aluno;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class AlunoRepository {

    List<Aluno> alunos = new ArrayList<>();
    Integer ultimoId = 0;

    /**
     * Metodo para etorna uma lista de alunos.
     *
     * @return Lista de alunos.
     */
    public List<Aluno> getAll() {
        return alunos;
    }

    /**
     * Metodo que retorna o aluno encontrado pelo id.
     *
     * @param id do aluno que será localizado.
     * @return Retorna um aluno caso seja encontrado.
     */
    public Optional<Aluno> getId(Integer id) {
        return alunos
                .stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst();
    }

    /**
     * Metodo para adicionar um aluno a lista.
     *
     * @param aluno a ser adicionado.
     * @return retorna o aluno que foi adicionado a lista.
     */
    public Aluno create(Aluno aluno) {
        ultimoId++;
        aluno.setId(ultimoId);
        alunos.add(aluno);
        return aluno;
    }


    /**
     * Metodo para deletar o aluno por ID.
     *
     * @param id do aluno a ser deletado.
     */
    public void delete(Integer id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }

    /**
     * Metodo para atualizar aluno pelo id
     *
     * @param aluno para atualizar a ser atualizado
     * @return retorna aluno atualizado
     */
    public Aluno update(Aluno aluno) {
        Optional<Aluno> found = getId(aluno.getId());

        if (found.isEmpty()) {
            throw new ResourceNotFoundException("Aluno not found");
        }
        delete(aluno.getId());
        alunos.add(aluno);
        return aluno;
    }
}
