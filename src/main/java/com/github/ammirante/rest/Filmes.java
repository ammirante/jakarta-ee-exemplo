package com.github.ammirante.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.ammirante.entidade.Filme;
import com.github.ammirante.servico.PersistenceService;

/**
 * Filmes
 *
 */
@Path("filmes")
public class Filmes {
	
    @Inject
    private PersistenceService persistenceService;
    
	/**
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFilmes() {
		return Response.ok(persistenceService.recuperarFilmes()).build();
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
 	public Response getFilme(@PathParam("id") Long id) {
		Filme filme = persistenceService.recuperarFilme(id);
		if(filme == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Id informado não encontrado.").build();
		}
		return Response.ok(persistenceService.recuperarFilme(id)).build();
	}
	
	/**
	 * @param filme
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarFilme(Filme filme) {
		try {
			persistenceService.salvarFilme(filme);
			
			return Response.status(Response.Status.CREATED).entity("Filme salvo com sucesso.").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao salvar filme." + e.getMessage()).build();
		}
	}
	
	/**
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarFilme(@PathParam("id") Long id) {
		try {
			persistenceService.deletarFilme(id);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar o filme." + e.getMessage()).build();
		}
	}
	
	/**
	 * @param filme
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarFilme(Filme filme) {
		try {
			persistenceService.atualizarFilme(filme);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar os dados do filme." + e.getMessage()).build();
		}
	}
}
