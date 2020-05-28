package com.github.ammirante.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.ammirante.entidade.Filme;

/**
 * FilmeServicoTest
 *
 */
@RunWith(Arquillian.class)
public class FilmeServicoTest {

    @Inject
    private PersistenceService persistenceService;

    @Inject
    private Filme filme;

    /**
     * @return
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PersistenceService.class.getPackage())
                .addPackage(Filme.class.getPackage())
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
    	filme.setAdulto(Boolean.TRUE);
    	filme.setDescricao("Um jovem programador é atormentado por estranhos pesadelos nos quais sempre est� conectado por cabos a um imenso sistema de computadores do futuro...");
    	filme.setCustoProducao(new BigDecimal("312521.321"));
    	filme.setReceita(new BigDecimal("23521312"));
    	filme.setTempoDuracao(120);
    	filme.setTitulo("Matrix");
    }

    
    /**
     * 
     */
    @Test
    public void salvarFilme() {
    	persistenceService.salvarFilme(filme);
    	
    	assertNotNull(filme.getId());
    	assertNotNull(filme.getAdulto());
    	assertNotNull(filme.getGeneros());
    	assertNotNull(filme.getCustoProducao());
    	assertNotNull(filme.getIdiomas());
    	assertNotNull(filme.getTitulo());
    	assertNotNull(filme.getDescricao());
    	assertNotNull(filme.getTempoDuracao());
    }
    
    
    /**
     * 
     */
    @Test
    public void atualizarFilme() {
    	filme = persistenceService.recuperarFilme(1L);
    	filme.setDescricao("Alterando a descrição");
    	persistenceService.atualizarFilme(filme);
    	
    	assertEquals(filme.getDescricao(), persistenceService.recuperarFilme(1L).getDescricao());
    }
    
    /**
     * 
     */
    @Test
    public void recuperarFilme() {
    	assertEquals(filme.getCustoProducao(), persistenceService.recuperarFilme(1L).getCustoProducao());
    }
    
    /**
     * 
     */
    @Test
    public void recuperarFilmes() {
    	assertEquals(1, persistenceService.recuperarFilmes().size());
    }
    
    /**
     * 
     */
    @Test
    public void deletarFilme() {
    	persistenceService.deletarFilme(1L);
    	
    	assertEquals(0, persistenceService.recuperarFilmes().size());
    }
}

