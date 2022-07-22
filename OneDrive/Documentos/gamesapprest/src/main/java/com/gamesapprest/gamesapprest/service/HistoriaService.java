package com.gamesapprest.gamesapprest.service;

import com.gamesapprest.gamesapprest.dominio.Historia;
import com.gamesapprest.gamesapprest.dominio.Jogos;
import com.gamesapprest.gamesapprest.repositorio.HistoriaRepository;
import com.gamesapprest.gamesapprest.repositorio.JogosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaService {
    HistoriaRepository repository;

    public HistoriaService(HistoriaRepository repository){
        this.repository = repository;
    }

    public Historia cadastrar(Historia h){
        return repository.save(h);
    }
    public void deletar(Integer id){
        repository.deleteById(id);
    }
    public Historia alterar(Historia h){
        return repository.saveAndFlush(h);
    }
    public Optional<Historia> buscar(Integer id){
        return repository.findById(id);
    }
    public List<Historia> relatorio(){
        return repository.findAll();
    }
}
