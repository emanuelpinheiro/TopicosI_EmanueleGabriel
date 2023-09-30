package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.GameGenreDTO;
import br.unitins.topicos1.dto.GameGenreResponseDTO;
import br.unitins.topicos1.model.GameGenre;
import br.unitins.topicos1.repository.GameGenreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GameGenreServiceImpl implements GameGenreService {
    
    @Inject
    GameGenreRepository repository;

    @Override
    @Transactional
    public GameGenreResponseDTO insert(GameGenreDTO dto) {
        GameGenre novoGameGenre = new GameGenre();
        novoGameGenre.setNome(dto.getNome());
        
        repository.persist(novoGameGenre);

        return GameGenreResponseDTO.valueOf(novoGameGenre);
    }

    @Override
    @Transactional
    public GameGenreResponseDTO update(GameGenreDTO dto, Long id) {
        GameGenre gameGenre = repository.findById(id);
        if (gameGenre != null) {
            gameGenre.setNome(dto.getNome());
        } else {
            throw new RuntimeException();
        }
        return GameGenreResponseDTO.valueOf(gameGenre);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<GameGenreResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> GameGenreResponseDTO.valueOf(e)).toList();
    }

    @Override
    public GameGenreResponseDTO findById(Long id) {
        return GameGenreResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<GameGenreResponseDTO> findByNome(String nome) {
        return repository.findByName(nome).stream()
            .map(e -> GameGenreResponseDTO.valueOf(e)).toList();
    }
}
