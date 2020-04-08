package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="lotacao")
public class Lotacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LotacaoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date entrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date saida;

	public Lotacao() {
	}

	public LotacaoPK getId() {
		return this.id;
	}

	public void setId(LotacaoPK id) {
		this.id = id;
	}

	public Date getEntrada() {
		return this.entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return this.saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

}