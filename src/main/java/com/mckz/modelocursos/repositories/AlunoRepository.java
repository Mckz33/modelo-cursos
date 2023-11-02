package com.mckz.modelocursos.repositories;

import com.mckz.modelocursos.models.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class AlunoRepository {

    List<Aluno> alunos = new ArrayList<>();
    long ultimoId = 0;

    /**
     * Metodo para etorna uma lista de produtos
     *
     * @return Lista de produtos
     */
    public List<Aluno> getAll() {
        return alunos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo id
     *
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional<Aluno> getId(Long id) {
        return alunos
                .stream()
                .filter(aluno -> aluno.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar um aluno a lista
     *
     * @param aluno a ser adicionado
     * @return retorna o produto que foi adicionado a lista
     */
    public Aluno create(Aluno aluno) {
        ultimoId++;
        aluno.setId(ultimoId);
        Long casting = (Long) ultimoId;
        alunos.add(aluno);
        return aluno;
    }

    /**
     * Metodo para deletar o produto por ID
     *
     * @param id do produto a ser deletado
     */
    public void delete(Long id) {
        alunos.removeIf(aluno -> aluno.getId() == id);
    }

    /**
     * Metodo para atualizar aluno pelo id
     *
     * @param aluno para atualizar a ser atualizado
     * @param id    para identificar o aluno
     * @return retorna aluno atualizado
     */
    public Aluno update(Aluno aluno, Long id) {
        Optional<Aluno> found = getId(id);
        if (found.isEmpty()) {
            throw new InputMismatchException("Aluno not found");
        }
        delete(id);
        create(aluno);
        return aluno;
    }
}
