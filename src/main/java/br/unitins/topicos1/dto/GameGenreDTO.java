package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public class GameGenreDTO {
    
    @NotBlank(message = "O campo nome é obrigatório")
    private final String nome;

    public GameGenreDTO(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        GameGenreDTO other = (GameGenreDTO) obj;
        if (nome == null){
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
}
