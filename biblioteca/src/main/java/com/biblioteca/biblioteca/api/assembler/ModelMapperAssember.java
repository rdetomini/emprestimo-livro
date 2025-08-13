package com.biblioteca.biblioteca.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ModelMapperAssember {

    private final ModelMapper modelMapper;

    public <D, E> E converter(D source, Class<E> entityClass) {
        return modelMapper.map(source, entityClass);
    }
    public <D, E> List<E> converter(List<D> source, Class<E> entityClass) {
        return source.stream().map(c -> modelMapper.map(c, entityClass)).toList();
    }
}
