package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.GameGenre;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameGenreRepository implements PanacheRepository<GameGenre>{
    public List<GameGenre> findByName(String nome){
        return find("UPPER(nome) LIKE UPPER(?1)", "%" + nome + "%").list();
    }

}
