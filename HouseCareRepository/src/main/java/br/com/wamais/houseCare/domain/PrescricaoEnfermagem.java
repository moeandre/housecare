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
 * The persistent class for the prescricao_enfermagem database table.
 * 
 */
@Entity
@Table(name="prescricao_enfermagem")
public class PrescricaoEnfermagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrescricaoEnfermagemPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Column(name="id_usuario")
	private int idUsuario;

	public PrescricaoEnfermagem() {
	}

	public PrescricaoEnfermagemPK getId() {
		return this.id;
	}

	public void setId(PrescricaoEnfermagemPK id) {
		this.id = id;
	}

	public Date getAlteracao() {
		return this.alteracao;
	}

	public void setAlteracao(Date alteracao) {
		this.alteracao = alteracao;
	}

	public Date getCriacao() {
		return this.criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}