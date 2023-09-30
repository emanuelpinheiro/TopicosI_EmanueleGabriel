package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.GameGenre;
import br.unitins.topicos1.repository.GameGenreRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/generos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameGenreResource {
    
    @Inject
    GameGenreRepository repository;

    @POST
    @Transactional
    public GameGenre insert(GameGenre gameGenre){
        GameGenre novoGameGenre = new GameGenre();
        novoGameGenre.setNome(gameGenre.getNome());
        
        repository.persist(gameGenre);
        return gameGenre;
    }

    @GET
    public List<GameGenre> findAll(){
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public GameGenre findById(Long id){
        return repository.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<GameGenre> findByName(String nome){
        return repository.findByName(nome);
    }
}
