package br.unitins.topicos1.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import br.unitins.topicos1.model.Game;
import br.unitins.topicos1.repository.GameRepository;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jogos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {

    @Inject
    GameRepository repository;

    @GET
    public List<Game> todosGames(){
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Game findById(@PathParam("id") Long id){
        return repository.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Game> findByName(@PathParam("nome") String nome){
        return repository.findByName(nome);
    }

    @POST
    @Transactional
    public Game insert(Game game){
        Game novoGame = new Game();
        novoGame.setNome(game.getNome());
        novoGame.setGenero(game.getGenero());
        novoGame.setPreco(game.getPreco());

        repository.persist(novoGame);
        return novoGame;
    }

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    @DELETE
    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Game game){
        Game gameToUpdate = repository.findById(id);
        if (gameToUpdate == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        gameToUpdate.setNome(game.getNome());
        gameToUpdate.setGenero(game.getGenero());
        gameToUpdate.setPreco(game.getPreco());

        repository.persist(gameToUpdate);
        return Response.ok(gameToUpdate).build();
    }
}
