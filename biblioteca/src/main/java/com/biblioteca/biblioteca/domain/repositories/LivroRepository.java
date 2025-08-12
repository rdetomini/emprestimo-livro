package com.biblioteca.biblioteca.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.biblioteca.domain.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
