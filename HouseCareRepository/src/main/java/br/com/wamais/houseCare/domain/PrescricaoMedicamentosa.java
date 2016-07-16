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
 * The persistent class for the prescricao_medicamentosa database table.
 * 
 */
@Entity
@Table(name="prescricao_medicamentosa")
public class PrescricaoMedicamentosa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrescricaoMedicamentosaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date criacao;

	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="pimeiro_horario")
	private String pimeiroHorario;

	private int quantidade;

	private int tempo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date validade;

	public PrescricaoMedicamentosa() {
	}

	public PrescricaoMedicamentosaPK getId() {
		return this.id;
	}

	public void setId(PrescricaoMedicamentosaPK id) {
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

	public String getPimeiroHorario() {
		return this.pimeiroHorario;
	}

	public void setPimeiroHorario(String pimeiroHorario) {
		this.pimeiroHorario = pimeiroHorario;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getTempo() {
		return this.tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Date getValidade() {
		return this.validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

}