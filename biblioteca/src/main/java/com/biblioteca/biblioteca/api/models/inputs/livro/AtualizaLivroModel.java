package com.biblioteca.biblioteca.api.models.inputs.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaLivroModel {
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    private String autor;

    @NotNull
    private int ano_publicacao;
}
