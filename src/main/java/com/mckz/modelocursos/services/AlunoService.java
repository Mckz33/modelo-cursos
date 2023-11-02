package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Aluno;
import com.mckz.modelocursos.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * Metodo para etorna uma lista de produtos.
     *
     * @return Lista de produtos.
     */
    public List<Aluno> getAll() {
        return alunoRepository.getAll();
    }

    /**
     * Metodo que retorna o aluno encontrado pelo id.
     *
     * @param id do aluno que será localizado.
     * @return Retorna um aluno caso seja encontrado.
     */
    public Optional<Aluno> getId(Integer id) {
        return alunoRepository.getId(id);
    }

    /**
     * Metodo para adicionar um aluno a lista.
     *
     * @param aluno a ser adicionado.
     * @return retorna o aluno que foi adicionado a lista.
     */
    public Aluno create(Aluno aluno) {
        return alunoRepository.create(aluno);
    }

    /**
     * Metodo para deletar o aluno por ID.
     *
     * @param id do aluno a ser deletado.
     */
    public void delete(Integer id) {
        alunoRepository.delete(id);
    }

    /**
     * Metodo para atualizar o aluno.
     *
     * @param id    do aluno para ser atualizado.
     * @param aluno a ser atualizado.
     * @return retorna o aluno atualizado.
     */
    public Aluno update(Integer id, Aluno aluno) {
        aluno.setId(id);
        return alunoRepository.update(aluno);
    }

}
