package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the atributo_familiar database table.
 *
 */
@Entity
@Table(name = "atributo_familiar")
public class AtributoFamiliar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 45)
	private String chave;

	@Column(name = "id_familiar", nullable = false)
	private int idFamiliar;

	@Column(nullable = false, length = 45)
	private String nome;

	@Column(nullable = false, length = 250)
	private String valor;

	public AtributoFamiliar() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public String getChave() {

		return this.chave;
	}

	public void setChave(final String chave) {

		this.chave = chave;
	}

	public int getIdFamiliar() {

		return this.idFamiliar;
	}

	public void setIdFamiliar(final int idFamiliar) {

		this.idFamiliar = idFamiliar;
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