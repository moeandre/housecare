package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FuncionarioPK id;

	private byte responsavel;

	private String situacao;

	public Funcionario() {
	}

	public FuncionarioPK getId() {
		return this.id;
	}

	public void setId(FuncionarioPK id) {
		this.id = id;
	}

	public byte getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(byte responsavel) {
		this.responsavel = responsavel;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}