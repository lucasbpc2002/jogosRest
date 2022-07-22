package com.gamesapprest.gamesapprest.repositorio;

import com.gamesapprest.gamesapprest.dominio.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosRepository  extends JpaRepository<Jogos, Integer> {
}
