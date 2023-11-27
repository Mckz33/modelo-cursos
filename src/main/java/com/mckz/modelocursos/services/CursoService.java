package com.mckz.modelocursos.services;

import com.mckz.modelocursos.models.Curso;
import com.mckz.modelocursos.models.exceptions.ResourceNotFoundException;
import com.mckz.modelocursos.repositories.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

    /**
     * Metodo que retorna o curso encontrado pelo id.
     *
     * @param id do curso que será localizado.
     * @return Retorna um curso caso seja encontrado.
     */
    public Optional<Curso> findById(Long id) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isEmpty()) {
            throw new ResourceNotFoundException("Curso não encontrado.");
        }
        return optionalCurso;
    }

    /**
     * Metodo para adicionar um curso a lista.
     *
     * @param curso a ser adicionado.
     * @return retorna o curso que foi adicionado a lista.
     */
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    /**
     * Metodo para deletar o curso por ID.
     *
     * @param curso do curso a ser deletado.
     */

    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }


}
