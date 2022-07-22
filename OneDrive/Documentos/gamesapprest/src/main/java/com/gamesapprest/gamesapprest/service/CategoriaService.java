package com.gamesapprest.gamesapprest.service;

import com.gamesapprest.gamesapprest.dominio.Categoria;
import com.gamesapprest.gamesapprest.dominio.Historia;
import com.gamesapprest.gamesapprest.repositorio.CategoriaRepository;
import com.gamesapprest.gamesapprest.repositorio.HistoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){
        this.repository = repository;
    }

    public Categoria cadastrar(Categoria c){
        return repository.save(c);
    }
    public void deletar(Integer id){
        repository.deleteById(id);
    }
    public Categoria alterar(Categoria c){
        return repository.saveAndFlush(c);
    }
    public Optional<Categoria> buscar(Integer id){
        return repository.findById(id);
    }
    public List<Categoria> relatorio(){
        return repository.findAll();
    }
}
