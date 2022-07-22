package com.gamesapprest.gamesapprest.dto.jogosDto;

import com.gamesapprest.gamesapprest.dominio.Categoria;
import com.gamesapprest.gamesapprest.dominio.Historia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogosRequestDto {
    String nome;
    String desenvolvedora;
    String empresa;
    String anolancamento;
    String plataformas;
    String preco;
    Historia historia;
    Categoria categoria;
}
