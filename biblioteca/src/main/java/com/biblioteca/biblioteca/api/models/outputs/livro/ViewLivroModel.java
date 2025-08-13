package com.biblioteca.biblioteca.api.models.outputs.livro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewLivroModel {
    private Long id;
    private String titulo;
    private String autor;
    private int ano_publicacao;
}
