package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the lotacao database table.
 *
 */
@Entity
@Table(name = "lotacao")
public class Lotacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LotacaoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date entrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date saida;

	public Lotacao() {

	}

	public LotacaoPK getId() {

		return this.id;
	}

	public void setId(final LotacaoPK id) {

		this.id = id;
	}

	public Date getEntrada() {

		return this.entrada;
	}

	public void setEntrada(final Date entrada) {

		this.entrada = entrada;
	}

	public Date getSaida() {

		return this.saida;
	}

	public void setSaida(final Date saida) {

		this.saida = saida;
	}

}