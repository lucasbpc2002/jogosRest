package com.gamesapprest.gamesapprest.repositorio;

import com.gamesapprest.gamesapprest.dominio.Historia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaRepository extends JpaRepository <Historia, Integer> {
}
