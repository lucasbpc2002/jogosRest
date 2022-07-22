package com.gamesapprest.gamesapprest.dto.jogosDto;

import com.gamesapprest.gamesapprest.controller.JogosController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
@Data
@NoArgsConstructor
public class JogosResponseDto extends RepresentationModel<JogosResponseDto> {
    String nome;
    String desenvolvedora;
    String empresa;
    String anolancamento;
    String plataformas;
    String preco;

    public void addHateoslinks(Integer id){
        this.add(linkTo(JogosController.class).slash(id).withSelfRel());
        this.add(linkTo(JogosController.class).withRel("GET"));
        this.add(linkTo(JogosController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(JogosController.class).slash(id).withRel("PUT"));
        this.add(linkTo(JogosController.class).withRel("POST"));
    }
}