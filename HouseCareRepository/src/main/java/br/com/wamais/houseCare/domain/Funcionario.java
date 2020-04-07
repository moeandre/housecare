package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * The persistent class for the funcionario database table.
 *
 */
@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FuncionarioPK id;

	@NotNull
	private byte responsavel;

	@NotBlank
	private String situacao;

	@Transient
	@Valid
	private Usuario usuario;

	public Funcionario() {

	}

	public FuncionarioPK getId() {

		return this.id;
	}

	public void setId(final FuncionarioPK id) {

		this.id = id;
	}

	public byte getResponsavel() {

		return this.responsavel;
	}

	public void setResponsavel(final byte responsavel) {

		this.responsavel = responsavel;
	}

	public String getSituacao() {

		return this.situacao;
	}

	public void setSituacao(final String situacao) {

		this.situacao = situacao;
	}

	public Usuario getUsuario() {

		return this.usuario;
	}

	public void setUsuario(final Usuario usuario) {

		this.usuario = usuario;
	}

}