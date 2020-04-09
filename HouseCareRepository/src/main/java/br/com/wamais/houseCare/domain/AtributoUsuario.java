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
 * The persistent class for the atributo_usuario database table.
 *
 */
@Entity
@Table(name = "atributo_usuario")
public class AtributoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AtributoUsuarioPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date criacao;

	@Column(nullable = false, length = 60)
	private String nome;

	@Column(nullable = false, length = 100)
	private String valor;

	public AtributoUsuario() {

	}

	public AtributoUsuarioPK getId() {

		return this.id;
	}

	public void setId(final AtributoUsuarioPK id) {

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