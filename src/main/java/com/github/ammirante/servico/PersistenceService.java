package com.github.ammirante.servico;

import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.github.ammirante.entidade.Filme;

/**
 * PersistenceService
 *
 */
@DataSourceDefinition(name = "java:app/Todo/MyDS", className = "org.sqlite.SQLiteDataSource", url = "jdbc:sqlite:C:/Downloads/sqlite-tools-win32-x86-3320100/todo.db")
@Local
@Stateless
public class PersistenceService {

	@Inject
	private QueryService queryService;

	/**
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Filme> recuperarFilmes() {
		return queryService.recuperarFilmes();
	}

	/**
	 * @param id
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public Filme recuperarFilme(Long id) {
		return queryService.recuperarFilme(id);
	}

	/**
	 * @param filme
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarFilme(Filme filme) {
		queryService.salvarFilme(filme);
	}
	
	/**
	 * @param id
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deletarFilme(Long id) {
		queryService.deletarFilme(id);
	}
	
	/**
	 * @param filme
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualizarFilme(Filme filme) {
		queryService.atualizarFilme(filme);
	}
}
