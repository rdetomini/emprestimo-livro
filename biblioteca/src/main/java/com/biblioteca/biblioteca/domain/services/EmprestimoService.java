package com.biblioteca.biblioteca.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.domain.entities.Emprestimo;
import com.biblioteca.biblioteca.domain.repositories.EmprestimoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    @Transactional
    public List<Emprestimo> salvar(List<Emprestimo> emprestimos) {
        return emprestimoRepository.saveAll(emprestimos);
    }

    public List<Emprestimo> getByPessoaId(long pessoaId) {
        return emprestimoRepository.findByPessoaId(pessoaId);
    }

}
