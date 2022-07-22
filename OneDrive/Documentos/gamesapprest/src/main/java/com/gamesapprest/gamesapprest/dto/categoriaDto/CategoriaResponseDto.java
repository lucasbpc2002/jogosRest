package com.gamesapprest.gamesapprest.dto.categoriaDto;

import com.gamesapprest.gamesapprest.controller.JogosController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class CategoriaResponseDto extends RepresentationModel<CategoriaResponseDto> {
    String nome;

    public void addHateoslinksCategoria(Integer id){
        this.add(linkTo(JogosController.class).slash(id).withSelfRel());
        this.add(linkTo(JogosController.class).withRel("GET"));
        this.add(linkTo(JogosController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(JogosController.class).slash(id).withRel("PUT"));
        this.add(linkTo(JogosController.class).withRel("POST"));
    }
}
