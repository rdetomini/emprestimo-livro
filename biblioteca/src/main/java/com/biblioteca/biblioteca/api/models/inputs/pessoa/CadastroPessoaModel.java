package com.biblioteca.biblioteca.api.models.inputs.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroPessoaModel {
    @NotBlank
    @NotNull
    private String nome;
    
    @NotNull
    @NotBlank
    private String email;
}
