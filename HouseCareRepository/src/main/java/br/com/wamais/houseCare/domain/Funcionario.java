package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

/**
 * The persistent class for the funcionario database table.
 *
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FuncionarioPK id;

	@Column(nullable = false)
	private byte responsavel;

	@Column(nullable = false, length = 1)
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