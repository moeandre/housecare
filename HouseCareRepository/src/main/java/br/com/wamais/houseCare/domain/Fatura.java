package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the fatura database table.
 *
 */
@Entity
@Table(name = "fatura")
public class Fatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "id_cobranca")
	private int idCobranca;

	public Fatura() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public int getIdCobranca() {

		return this.idCobranca;
	}

	public void setIdCobranca(final int idCobranca) {

		this.idCobranca = idCobranca;
	}

}