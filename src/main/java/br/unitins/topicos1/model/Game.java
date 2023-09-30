package br.unitins.topicos1.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    public String nome;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    public GameGenre genero;
    public String preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public GameGenre getGenero() {
        return genero;
    }

    public String getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            throw new RuntimeException("Nome do jogo obrigatório");
        }
        this.nome = nome;
    }

    public void setGenero(GameGenre genero) {
        if (genero == null) {
            throw new RuntimeException("Gênero do jogo obrigatório");
        }
        this.genero = genero;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
