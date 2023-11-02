package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Curso;
import com.mckz.modelocursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    /**
     * Metodo para etorna uma lista de produtos.
     *
     * @return Lista de produtos.
     */
    public List<Curso> getAll() {
        return cursoRepository.getAll();
    }

    /**
     * Metodo que retorna o curso encontrado pelo id.
     *
     * @param id do curso que será localizado.
     * @return Retorna um curso caso seja encontrado.
     */
    public Optional<Curso> getId(Integer id) {
        return cursoRepository.getId(id);
    }

    /**
     * Metodo para adicionar um curso a lista.
     *
     * @param curso a ser adicionado.
     * @return retorna o curso que foi adicionado a lista.
     */
    public Curso create(Curso curso) {
        return cursoRepository.create(curso);
    }

    /**
     * Metodo para deletar o curso por ID.
     *
     * @param id do curso a ser deletado.
     */
    public void delete(Integer id) {
        cursoRepository.delete(id);
    }

    /**
     * Metodo para atualizar o curso.
     *
     * @param id    do curso para ser atualizado.
     * @param curso a ser atualizado.
     * @return retorna o curso atualizado.
     */
    public Curso update(Integer id, Curso curso) {
        curso.setId(id);
        return cursoRepository.update(curso);
    }

}
