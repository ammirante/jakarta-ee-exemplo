package com.github.ammirante.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.github.ammirante.entidade.Filme;

/**
 * QueryService
 *
 */
@Stateless
public class QueryService {

    @PersistenceContext
    EntityManager em;

    /**
     * @return
     */
	public List<Filme> recuperarFilmes() {
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT F FROM Filme F ORDER BY F.titulo");
    	
    	TypedQuery<Filme> query = em.createQuery(sql.toString(), Filme.class);
    	
    	return query.getResultList();
    }
    
    /**
     * @param id
     */
    public void deletarFilme(Long id) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("DELETE FROM Filme WHERE id = :id");
    	
    	em.createQuery(sql.toString())
    	.setParameter("id", id)
    	.executeUpdate();
    }
    
    /**
     * @param filme
     */
    public void salvarFilme(Filme filme) {
		em.persist(filme);
    }
    
    /**
     * @param id
     * @return
     */
    public Filme recuperarFilme(Long id) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT F FROM Filme F WHERE F.id = :id");
    	
    	Query query = em.createQuery(sql.toString(), Filme.class);
    	query.setParameter("id", id);
    	
    	try {
    		return (Filme) query.getSingleResult();
    	} catch (NonUniqueResultException | NoResultException e) {
    		return null;
		}
    }
    
    /**
     * @param filme
     */
    public void atualizarFilme(Filme filme) {
		em.merge(filme);
    }
}
