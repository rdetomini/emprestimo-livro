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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.api.assembler.ModelMapperAssember;
import com.biblioteca.biblioteca.api.models.inputs.pessoa.AtualizaPessoaModel;
import com.biblioteca.biblioteca.api.models.inputs.pessoa.CadastroPessoaModel;
import com.biblioteca.biblioteca.api.models.outputs.pessoa.ViewPessoaModel;
import com.biblioteca.biblioteca.domain.entities.Pessoa;
import com.biblioteca.biblioteca.domain.services.PessoaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;
    private final ModelMapperAssember modelMapper;

    @GetMapping
    public List<ViewPessoaModel> getAll() {
        List<Pessoa> pessoas = pessoaService.getAll();
        return modelMapper.converter(pessoas, ViewPessoaModel.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewPessoaModel> getById(@PathVariable long id) {
        return pessoaService.getById(id)
                .map(p -> modelMapper.converter(p, ViewPessoaModel.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewPessoaModel salvar(@Valid @RequestBody CadastroPessoaModel pessoaModel) {
        Pessoa pessoaEntity = modelMapper.converter(pessoaModel, Pessoa.class);
        Pessoa pessoaSalva = pessoaService.salvar(pessoaEntity);
        return modelMapper.converter(pessoaSalva, ViewPessoaModel.class);
    }

    @PutMapping
    public ResponseEntity<ViewPessoaModel> atualizar(@Valid @RequestBody AtualizaPessoaModel pessoaModel) {
        if (pessoaService.getById(pessoaModel.getId()).isPresent()) {
            Pessoa pessoaEntity = modelMapper.converter(pessoaModel, Pessoa.class);
            Pessoa pessoaAtualizada = pessoaService.salvar(pessoaEntity);
            ViewPessoaModel pessoaView = modelMapper.converter(pessoaAtualizada, ViewPessoaModel.class);
            return ResponseEntity.ok(pessoaView);
        }

        return ResponseEntity.notFound().build();
    }
}
