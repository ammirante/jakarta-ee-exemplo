package com.github.ammirante.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Idioma
 *
 */
@Entity
@Table(name = "idioma")
public class Idioma {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idioma_sequence")
	@SequenceGenerator(name="idioma_sequence", sequenceName = "idioma_sequence")
	protected Long id;

	@Column(nullable = false, length = 20, unique = true, updatable = true)
	private String idioma;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "filme_id")
	private Filme filme;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * @return the filme
	 */
	public Filme getFilme() {
		return filme;
	}

	/**
	 * @param filme the filme to set
	 */
	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Idioma [id=" + id + ", idioma=" + idioma + ", filme=" + filme + "]";
	}
}