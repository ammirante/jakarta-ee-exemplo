package com.github.ammirante.servico;

import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.github.ammirante.entidade.Filme;

/**
 * PersistenceService
 *
 */
@DataSourceDefinition(name = "java:app/Todo/MyDS", className = "org.sqlite.SQLiteDataSource", url = "jdbc:sqlite:C:/Downloads/sqlite-tools-win32-x86-3320100/todo.db")
@Stateless
public class PersistenceService {

	@Inject
	private QueryService queryService;

	/**
	 * @return
	 */
	public List<Filme> recuperarFilmes() {
		return queryService.recuperarFilmes();
	}

	/**
	 * @param id
	 * @return
	 */
	public Filme recuperarFilme(Long id) {
		return queryService.recuperarFilme(id);
	}

	/**
	 * @param filme
	 */
	public void salvarFilme(Filme filme) {
		queryService.salvarFilme(filme);
	}
	
	/**
	 * @param id
	 */
	public void deletarFilme(Long id) {
		queryService.deletarFilme(id);
	}
	
	/**
	 * @param filme
	 */
	public void atualizarFilme(Filme filme) {
		queryService.atualizarFilme(filme);
	}
}
