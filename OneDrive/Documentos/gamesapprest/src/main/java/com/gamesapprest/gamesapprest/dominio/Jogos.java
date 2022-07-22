package com.gamesapprest.gamesapprest.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    String nome;
    @NotBlank
    String desenvolvedora;
    @NotBlank
    String empresa;
    @NotBlank
    String anolancamento;
    @NotBlank
    String plataformas;
    @NotBlank
    String preco;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "historia_id")
    Historia historia;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "categoria_id")
    Categoria categoria;
}
