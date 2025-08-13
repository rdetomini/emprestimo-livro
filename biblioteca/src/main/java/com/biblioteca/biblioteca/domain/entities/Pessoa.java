package com.biblioteca.biblioteca.domain.entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pessoas")
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank    
    @NotNull
    private String nome;
    
    @NotBlank    
    @NotNull
    private String email;

    @OneToMany(mappedBy="pessoa")
    private List<Emprestimo> emprestimos;
}
