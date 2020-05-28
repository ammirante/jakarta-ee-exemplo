package com.github.ammirante.entidade;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

/**
 * Filme
 *
 */
@Entity(name = "Filme")
@Table(name = "filme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filme_sequence")
	@SequenceGenerator(name = "filme_sequence", sequenceName = "filme_sequence")
	private Long id;

	@Column(nullable = false, updatable = false)
	private Boolean adulto;

	@OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "filme_id")
	private List<Genero> generos;

	@Column(nullable = false, precision = 15, scale = 2, updatable = true)
	@Positive(message = "O custo de produção deve ser maior que 0.")
	private BigDecimal custoProducao;

	@OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "filme_id")
	private List<Idioma> idiomas;

	@Column(nullable = false, length = 30, updatable = false)
	private String titulo;

	@Column(nullable = false, updatable = true)
	private String descricao;

	@Column(nullable = true, updatable = true, precision = 15, scale = 2)
	private BigDecimal receita;

	@Column(nullable = false, updatable = false)
	@Positive(message = "A duração do filme deve ser maior que 0.")
	private Integer tempoDuracao;

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
	 * @return the adulto
	 */
	public Boolean getAdulto() {
		return adulto;
	}

	/**
	 * @param adulto the adulto to set
	 */
	public void setAdulto(Boolean adulto) {
		this.adulto = adulto;
	}

	/**
	 * @return the generos
	 */
	public List<Genero> getGeneros() {
		return generos;
	}

	/**
	 * @param generos the generos to set
	 */
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	/**
	 * @return the custoProducao
	 */
	public BigDecimal getCustoProducao() {
		return custoProducao;
	}

	/**
	 * @param custoProducao the custoProducao to set
	 */
	public void setCustoProducao(BigDecimal custoProducao) {
		this.custoProducao = custoProducao;
	}

	/**
	 * @return the idiomas
	 */
	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	/**
	 * @param idiomas the idiomas to set
	 */
	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the receita
	 */
	public BigDecimal getReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(BigDecimal receita) {
		this.receita = receita;
	}

	/**
	 * @return the tempoDuracao
	 */
	public Integer getTempoDuracao() {
		return tempoDuracao;
	}

	/**
	 * @param tempoDuracao the tempoDuracao to set
	 */
	public void setTempoDuracao(Integer tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Filme [id=" + id + ", adulto=" + adulto + ", generos=" + generos + ", custoProducao=" + custoProducao
				+ ", idiomas=" + idiomas + ", titulo=" + titulo + ", descricao=" + descricao + ", receita=" + receita
				+ ", tempoDuracao=" + tempoDuracao + "]";
	}
}