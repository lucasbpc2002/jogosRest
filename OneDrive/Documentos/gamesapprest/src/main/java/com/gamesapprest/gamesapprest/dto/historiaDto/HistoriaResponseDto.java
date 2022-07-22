package com.gamesapprest.gamesapprest.dto.historiaDto;

import com.gamesapprest.gamesapprest.controller.JogosController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class HistoriaResponseDto extends RepresentationModel<HistoriaResponseDto> {
    String historia;

    public void addHateoslinksHistoria(Integer id){
        this.add(linkTo(JogosController.class).slash(id).withSelfRel());
        this.add(linkTo(JogosController.class).withRel("GET"));
        this.add(linkTo(JogosController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(JogosController.class).slash(id).withRel("PUT"));
        this.add(linkTo(JogosController.class).withRel("POST"));
    }
}
