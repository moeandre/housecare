package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the anotacao database table.
 *
 */
@Entity
public class Anotacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AnotacaoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Lob
	@NotNull
	private String texto;

	@Transient
	private Usuario usuario;

	public Anotacao() {

	}

	public AnotacaoPK getId() {

		return this.id;
	}

	public void setId(final AnotacaoPK id) {

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

	public String getTexto() {

		return this.texto;
	}

	public void setTexto(final String texto) {

		this.texto = texto;
	}

	public Usuario getUsuario() {

		return this.usuario;
	}

	public void setUsuario(final Usuario usuario) {

		this.usuario = usuario;
	}

}