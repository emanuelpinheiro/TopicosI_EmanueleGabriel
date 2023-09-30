package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.GameGenre;

public record GameGenreResponseDTO (
    Long id,
    String nome
) {
    public static GameGenreResponseDTO valueOf(GameGenre gamegenre) {
        return new GameGenreResponseDTO(
            gamegenre.getId(),
            gamegenre.getNome());
    }
}