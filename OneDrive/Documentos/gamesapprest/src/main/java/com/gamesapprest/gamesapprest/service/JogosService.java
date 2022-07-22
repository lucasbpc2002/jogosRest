package com.gamesapprest.gamesapprest.service;

import com.gamesapprest.gamesapprest.dominio.Jogos;
import com.gamesapprest.gamesapprest.repositorio.JogosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogosService {
    JogosRepository repository;

    public JogosService(JogosRepository repository){
        this.repository = repository;
    }

    public Jogos cadastrar(Jogos j){
        return repository.save(j);
    }
    public void deletar(Integer id){
        repository.deleteById(id);
    }
    public Jogos alterar(Jogos j){
        return repository.saveAndFlush(j);
    }
    public Optional<Jogos> buscar(Integer id){
        return repository.findById(id);
    }
    public List<Jogos> relatorio(){
        return repository.findAll();
    }
}
