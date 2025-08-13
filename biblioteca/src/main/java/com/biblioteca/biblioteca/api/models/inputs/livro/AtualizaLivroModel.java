package com.biblioteca.biblioteca.api.models.inputs.livro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaLivroModel {

    private Long id;
    private String titulo;
    private String autor;
    private int ano_publicacao;
}
