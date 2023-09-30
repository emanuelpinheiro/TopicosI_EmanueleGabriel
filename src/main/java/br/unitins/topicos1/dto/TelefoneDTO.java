package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;

public record TelefoneDTO (
    String ddd,
    String numero
) {
    public static TelefoneDTO valueOf(Telefone telefone) {
        return new TelefoneDTO(
            telefone.getDdd(),
            telefone.getNumero());
    }
}
    
