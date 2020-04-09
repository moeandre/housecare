package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The persistent class for the configuracao database table.
 *
 */
@Entity
@Table(name = "configuracao")
public class Configuracao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConfiguracaoPK id;

	@Column(nullable = false, length = 75)
	private String nome;

	@Lob
	@Column(nullable = false)
	private String valor;

	public Configuracao() {

	}

	public ConfiguracaoPK getId() {

		return this.id;
	}

	public void setId(final ConfiguracaoPK id) {

		this.id = id;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getValor() {

		return this.valor;
	}

	public void setValor(final String valor) {

		this.valor = valor;
	}

}