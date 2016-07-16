package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


/**
 * The persistent class for the historico database table.
 * 
 */
@Entity
public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoricoPK id;

	private String valor;

	public Historico() {
	}

	public HistoricoPK getId() {
		return this.id;
	}

	public void setId(HistoricoPK id) {
		this.id = id;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}