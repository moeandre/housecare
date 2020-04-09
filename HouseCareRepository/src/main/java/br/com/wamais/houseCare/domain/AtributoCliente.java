package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the atributo_cliente database table.
 *
 */
@Entity
@Table(name = "atributo_cliente")
public class AtributoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 45)
	private String chave;

	@Column(name = "id_cliente", nullable = false)
	private int idCliente;

	@Column(name = "id_empresa", nullable = false)
	private int idEmpresa;

	@Column(nullable = false, length = 45)
	private String nome;

	@Column(nullable = false, length = 250)
	private String valor;

	public AtributoCliente() {

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

	public int getIdCliente() {

		return this.idCliente;
	}

	public void setIdCliente(final int idCliente) {

		this.idCliente = idCliente;
	}

	public int getIdEmpresa() {

		return this.idEmpresa;
	}

	public void setIdEmpresa(final int idEmpresa) {

		this.idEmpresa = idEmpresa;
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