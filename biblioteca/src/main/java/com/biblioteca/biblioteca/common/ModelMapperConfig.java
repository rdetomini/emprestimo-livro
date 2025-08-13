package com.biblioteca.biblioteca.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.biblioteca.biblioteca.api.models.inputs.emprestimo.AtualizaEmprestimoModel;
import com.biblioteca.biblioteca.api.models.inputs.emprestimo.CadastroEmprestimoModel;
import com.biblioteca.biblioteca.api.models.inputs.livro.AtualizaLivroModel;
import com.biblioteca.biblioteca.api.models.inputs.livro.CadastroLivroModel;
import com.biblioteca.biblioteca.api.models.inputs.pessoa.AtualizaPessoaModel;
import com.biblioteca.biblioteca.api.models.inputs.pessoa.CadastroPessoaModel;
import com.biblioteca.biblioteca.api.models.outputs.emprestimo.ViewEmprestimoModel;
import com.biblioteca.biblioteca.api.models.outputs.livro.ViewLivroModel;
import com.biblioteca.biblioteca.api.models.outputs.pessoa.ViewPessoaModel;
import com.biblioteca.biblioteca.domain.entities.Emprestimo;
import com.biblioteca.biblioteca.domain.entities.Livro;
import com.biblioteca.biblioteca.domain.entities.Pessoa;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Pessoa.class, ViewPessoaModel.class);
        modelMapper.createTypeMap(Livro.class, ViewLivroModel.class);
        modelMapper.createTypeMap(Emprestimo.class, ViewEmprestimoModel.class);

        modelMapper.createTypeMap(Pessoa.class, CadastroPessoaModel.class);
        modelMapper.createTypeMap(Livro.class, CadastroLivroModel.class);
        modelMapper.createTypeMap(Emprestimo.class, CadastroEmprestimoModel.class);

        modelMapper.createTypeMap(Pessoa.class, AtualizaPessoaModel.class);
        modelMapper.createTypeMap(Livro.class, AtualizaLivroModel.class);
        modelMapper.createTypeMap(Emprestimo.class, AtualizaEmprestimoModel.class);

        return modelMapper;
    }
}
