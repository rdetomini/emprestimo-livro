package com.biblioteca.biblioteca.domain.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.domain.entities.Pessoa;
import com.biblioteca.biblioteca.domain.repositories.PessoaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> getById(long id) {
        return pessoaRepository.findById(id);
    }
}
