package com.biblioteca.biblioteca.api.models.inputs.livro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroLivroModel {
    private String titulo;
    private String autor;
    private int ano_publicacao;
}
