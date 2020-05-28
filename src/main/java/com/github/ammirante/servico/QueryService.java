package com.github.ammirante.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    @SuppressWarnings("unchecked")
	public List<Filme> recuperarFilmes() {
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT * FROM FILME");
    	
    	Query query = em.createNativeQuery(sql.toString());
    	
    	return query.getResultList();
    }
    
    /**
     * @param filme
     */
    public void salvarFilme(Filme filme) {
    	if(filme.getId() != null) {
    		em.merge(filme);
    	} else {
    		em.persist(filme);
    	}
    }
    
    /**
     * @param id
     * @return
     */
    public Filme recuperarFilme(Long id) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT * FROM FILME F WHERE F.ID = ?");
    	
    	Query query = em.createNativeQuery(sql.toString());
    	query.setParameter(1, id);
    	
    	try {
    		return (Filme) query.getSingleResult();
    	} catch (NonUniqueResultException | NoResultException e) {
    		return null;
		}
    }
}
