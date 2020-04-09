package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the caixa database table.
 *
 */
@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CaixaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	public Caixa() {

	}

	public CaixaPK getId() {

		return this.id;
	}

	public void setId(final CaixaPK id) {

		this.id = id;
	}

	public Date getAlteracao() {

		return this.alteracao;
	}

	public void setAlteracao(final Date alteracao) {

		this.alteracao = alteracao;
	}

	public Date getCriacao() {

		return this.criacao;
	}

	public void setCriacao(final Date criacao) {

		this.criacao = criacao;
	}

	public BigDecimal getValor() {

		return this.valor;
	}

	public void setValor(final BigDecimal valor) {

		this.valor = valor;
	}

}