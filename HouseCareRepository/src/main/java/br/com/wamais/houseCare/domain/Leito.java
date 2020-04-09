package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the leito database table.
 *
 */
@Entity
@Table(name = "leito")
public class Leito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "id_quarto")
	private int idQuarto;

	private String numero;

	private String situacao;

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public int getIdQuarto() {

		return this.idQuarto;
	}

	public void setIdQuarto(final int idQuarto) {

		this.idQuarto = idQuarto;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getSituacao() {

		return this.situacao;
	}

	public void setSituacao(final String situacao) {

		this.situacao = situacao;
	}

}