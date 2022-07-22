package com.gamesapprest.gamesapprest.controller;

import com.gamesapprest.gamesapprest.dominio.Jogos;
import com.gamesapprest.gamesapprest.dto.jogosDto.JogosRequestDto;
import com.gamesapprest.gamesapprest.dto.jogosDto.JogosResponseDto;
import com.gamesapprest.gamesapprest.service.JogosService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogosController {
    ModelMapper modelMapper = new ModelMapper();
    JogosService service;
    public JogosController(JogosService service){
        this.service = service;
    }
    @GetMapping
    public List<Jogos> relatorioJogos(){
        return service.relatorio();
    }

    @GetMapping(path = {"/{id}"})//funcionando
    public ResponseEntity<JogosResponseDto> findById(@PathVariable Integer id){
        Optional<Jogos> j  = service.buscar(id);
        if (j.isPresent()){
            Jogos jogos = j.get();
            JogosResponseDto jogosResponseDto = modelMapper.map(jogos, JogosResponseDto.class);
            jogosResponseDto.addHateoslinks(jogos.getId());
            return ResponseEntity.ok().body(jogosResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Jogos> cadastrar(@RequestBody JogosRequestDto j) throws URISyntaxException {
        Jogos jogos = modelMapper.map(j, Jogos.class);
        service.cadastrar(jogos);
        URI uri = new URI("/jogos/" + jogos.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogos> update (@PathVariable Integer id, @RequestBody Jogos j){
        if (service.buscar(id).isPresent()){
            Jogos atualizado = service.alterar(j);
            return ResponseEntity.ok().body(atualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id ){
        if (service.buscar(id).isPresent()){
            service.deletar(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
