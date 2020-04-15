package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the quarto database table.
 *
 */
@Entity
@Table(name = "quarto")
public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuartoPK id;

	@Column(nullable = false)
	private int lotacao;

	@Column(nullable = false, length = 3)
	private String numero;

	@Column(nullable = false, length = 1)
	private String situacao;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	public Quarto() {

	}

	public QuartoPK getId() {

		return this.id;
	}

	public void setId(final QuartoPK id) {

		this.id = id;
	}

	public int getLotacao() {

		return this.lotacao;
	}

	public void setLotacao(final int lotacao) {

		this.lotacao = lotacao;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getSituacao() {

		return this.situacao;
	}

	public void setSituacao(final String situacao) {

		this.situacao = situacao;
	}

	public BigDecimal getValor() {

		return this.valor;
	}

	public void setValor(final BigDecimal valor) {

		this.valor = valor;
	}

}