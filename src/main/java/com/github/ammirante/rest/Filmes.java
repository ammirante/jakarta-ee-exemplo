package com.github.ammirante.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.ammirante.entidade.Filme;
import com.github.ammirante.servico.PersistenceService;

/**
 * Filmes
 *
 */
@Path("filmes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Filmes {
	
    @Inject
    private PersistenceService persistenceService;
    
	/**
	 * @return
	 */
	@GET
	public Response getFilmes() {
		return Response.ok(persistenceService.recuperarFilmes()).build();
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	public Filme getFilme(@PathParam("id") Long id) {
		return persistenceService.recuperarFilme(id);
	}
	
	/**
	 * @param filme
	 */
	@POST
	public void salvarFilme(Filme filme) {
		persistenceService.salvarFilme(filme);
	}

}
