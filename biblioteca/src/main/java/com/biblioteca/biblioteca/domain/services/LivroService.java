package com.biblioteca.biblioteca.domain.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.domain.entities.Livro;
import com.biblioteca.biblioteca.domain.repositories.LivroRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    @Transactional
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> getById(long id) {
        return livroRepository.findById(id);
    }
}
