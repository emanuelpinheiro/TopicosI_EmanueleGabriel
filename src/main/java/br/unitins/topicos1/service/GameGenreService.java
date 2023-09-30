package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.GameGenreDTO;
import br.unitins.topicos1.dto.GameGenreResponseDTO;

public interface GameGenreService {

    public GameGenreResponseDTO insert(GameGenreDTO dto);

    public GameGenreResponseDTO update(GameGenreDTO dto, Long id);

    public void delete(Long id);

    public List<GameGenreResponseDTO> findByAll();

    public GameGenreResponseDTO findById(Long id);

    public List<GameGenreResponseDTO> findByNome(String nome);
    
}
