package com.biblioteca.biblioteca.api.models.outputs.emprestimo;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewEmprestimoModel {
    private Long id;
    private Long livro_id;
    private OffsetDateTime data_emprestimo;
    private OffsetDateTime data_devolucao;
}
