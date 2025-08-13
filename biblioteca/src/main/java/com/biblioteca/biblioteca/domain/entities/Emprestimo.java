package com.biblioteca.biblioteca.domain.entities;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emprestimos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    private OffsetDateTime data_emprestimo;

    private OffsetDateTime data_devolucao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public void devolucao() {
        this.data_devolucao = OffsetDateTime.now();
    }

    public void cadastraDataEmprestimo() {
        this.data_emprestimo = OffsetDateTime.now();
    }

    public void inserirPessoaELivro(Long pessoaId, Long livroId) {
        Livro livro = new Livro();
        livro.setId(livroId);
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaId);

        this.setLivro(livro);
        this.setPessoa(pessoa);
        this.cadastraDataEmprestimo();
    }
}
