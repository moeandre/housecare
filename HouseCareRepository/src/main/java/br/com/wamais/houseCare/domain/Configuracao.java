package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


/**
 * The persistent class for the configuracao database table.
 * 
 */
@Entity
public class Configuracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConfiguracaoPK id;

	private int quartos;

	public Configuracao() {
	}

	public ConfiguracaoPK getId() {
		return this.id;
	}

	public void setId(ConfiguracaoPK id) {
		this.id = id;
	}

	public int getQuartos() {
		return this.quartos;
	}

	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

}