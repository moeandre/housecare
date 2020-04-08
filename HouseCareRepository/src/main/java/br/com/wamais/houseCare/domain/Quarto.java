package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the quarto database table.
 * 
 */
@Entity
@Table(name="quarto")
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuartoPK id;

	private int lotacao;

	private String numero;

	private String situacao;

	public Quarto() {
	}

	public QuartoPK getId() {
		return this.id;
	}

	public void setId(QuartoPK id) {
		this.id = id;
	}

	public int getLotacao() {
		return this.lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}