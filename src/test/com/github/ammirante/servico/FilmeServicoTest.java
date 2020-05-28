package com.github.ammirante.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

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
import com.github.ammirante.entidade.Genero;
import com.github.ammirante.entidade.Idioma;

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

    @Inject
    private Genero genero;
    
    @Inject
    private Idioma idioma;

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
    	filme.setDescricao("Um jovem programador � atormentado por estranhos pesadelos nos quais sempre est� conectado por cabos a um imenso sistema de computadores do futuro...");
    	filme.setCustoProducao(new BigDecimal("312521.321"));
    	filme.setReceita(new BigDecimal("23521312"));
    	filme.setTempoDuracao(120);
    	filme.setTitulo("Matrix");
    	filme.setDataLancamento(LocalDate.now());
    	
    	genero.setNome("Drama");
    	idioma.setIdioma("Ingl�s");
    	
    	filme.setIdiomas(Arrays.asList(idioma));
    	filme.setGeneros(Arrays.asList(genero));
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
    	assertNotNull(filme.getDataLancamento());
    	assertNotNull(filme.getTempoDuracao());
    }
    
//    /**
//     * 
//     */
//    @Test
//    public void recuperarFilmes() {
//    	assertEquals(0, persistenceService.recuperarFilmes().size());
//    	persistenceService.salvarFilme(filme);
//    	assertEquals(1, persistenceService.recuperarFilmes().size());
//    }
//    
//    /**
//     * 
//     */
//    @Test
//    public void atualizarFilme() {
//    	// Salvando o primeiro filme.
//    	persistenceService.salvarFilme(filme);
//    	
//    	filme.setDescricao("Alterando a descrição");
//    	persistenceService.atualizarFilme(filme);
//    	
//    	assertEquals(filme.getDescricao(), persistenceService.recuperarFilme(1L).getDescricao());
//    }
}

