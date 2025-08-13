package com.biblioteca.biblioteca.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.api.assembler.ModelMapperAssember;
import com.biblioteca.biblioteca.api.models.inputs.livro.AtualizaLivroModel;
import com.biblioteca.biblioteca.api.models.inputs.livro.CadastroLivroModel;
import com.biblioteca.biblioteca.api.models.outputs.livro.ViewLivroModel;
import com.biblioteca.biblioteca.domain.entities.Livro;
import com.biblioteca.biblioteca.domain.services.LivroService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/livro")
@AllArgsConstructor
public class LivroController {
    private final LivroService livroService;
    private final ModelMapperAssember modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewLivroModel salvar(@Valid @RequestBody CadastroLivroModel livroModel) {
        Livro livro = modelMapper.converter(livroModel, Livro.class);
        Livro livroEntity = livroService.salvar(livro);
        
        ViewLivroModel livroMapeado = modelMapper.converter(livroEntity, ViewLivroModel.class);

        return livroMapeado;
    }

    @GetMapping
    public List<ViewLivroModel> getAll() {
        List<Livro> listaLivro = livroService.getAll();

        return modelMapper.converter(listaLivro, ViewLivroModel.class);
    }

    @PutMapping()
    public ResponseEntity<ViewLivroModel> atualizar(@Valid @RequestBody AtualizaLivroModel livroModel) {
        
        if(!livroService.getById(livroModel.getId()).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Livro livroEntity = modelMapper.converter(livroModel, Livro.class);
        Livro livroAtualizado = livroService.salvar(livroEntity);

        ViewLivroModel viewLivroModel = modelMapper.converter(livroAtualizado, ViewLivroModel.class);

        return ResponseEntity.ok(viewLivroModel);
    }

}
