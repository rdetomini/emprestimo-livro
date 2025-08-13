package com.biblioteca.biblioteca.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.api.assembler.ModelMapperAssember;
import com.biblioteca.biblioteca.api.models.inputs.emprestimo.AtualizaEmprestimoModel;
import com.biblioteca.biblioteca.api.models.inputs.emprestimo.CadastroEmprestimoModel;
import com.biblioteca.biblioteca.api.models.outputs.emprestimo.ViewEmprestimoModel;
import com.biblioteca.biblioteca.domain.entities.Emprestimo;
import com.biblioteca.biblioteca.domain.services.EmprestimoService;
import com.biblioteca.biblioteca.domain.services.PessoaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/emprestimo")
@RestController
@AllArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final PessoaService pessoaService;
    private final ModelMapperAssember modelMapper;

    @PostMapping("/{pessoaId}")
    public ResponseEntity<List<ViewEmprestimoModel>> salvar(@PathVariable long pessoaId, @Valid @RequestBody List<CadastroEmprestimoModel> emprestimosModel) {

        if (!pessoaService.getById(pessoaId).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Emprestimo> emprestimos = modelMapper.converter(emprestimosModel, Emprestimo.class);
        emprestimos.forEach(Emprestimo::cadastraDataEmprestimo);

        List<Emprestimo> emprestimosSalvo = emprestimoService.salvar(emprestimos);

        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.converter(emprestimosSalvo, ViewEmprestimoModel.class));
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<List<ViewEmprestimoModel>> devolucao(@PathVariable long pessoaId, @Valid @RequestBody List<AtualizaEmprestimoModel> emprestimoModel) {
        if (!pessoaService.getById(pessoaId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Long> ids = modelMapper.converter(emprestimoModel, Long.class);
        List<Emprestimo> emprestimos = emprestimoService.getByIds(ids);

        emprestimos.forEach(e -> e.devolucao());

        List<Emprestimo> emprestimosSalvo = emprestimoService.salvar(emprestimos);

        List<ViewEmprestimoModel> emprestimosViewModel = modelMapper.converter(emprestimosSalvo, ViewEmprestimoModel.class);

        return ResponseEntity.ok(emprestimosViewModel);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<ViewEmprestimoModel>> getAll(@PathVariable long pessoaId) {
        if (!pessoaService.getById(pessoaId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Emprestimo> emprestimos = emprestimoService.getByPessoaId(pessoaId);
        List<ViewEmprestimoModel> emprestimosViewModel = modelMapper.converter(emprestimos, ViewEmprestimoModel.class);
        return ResponseEntity.ok(emprestimosViewModel);
    }
}
