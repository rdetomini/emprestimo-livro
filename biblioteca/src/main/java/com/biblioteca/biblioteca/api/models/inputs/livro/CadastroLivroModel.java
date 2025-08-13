package com.biblioteca.biblioteca.api.models.inputs.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroLivroModel {
    @NotBlank
    @NotNull
    private String titulo;

    @NotBlank
    @NotNull
    private String autor;
    
    @NotNull
    private int ano_publicacao;
}
