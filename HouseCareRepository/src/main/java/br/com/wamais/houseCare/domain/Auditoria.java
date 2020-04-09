package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the auditoria database table.
 *
 */
@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 100)
	private String classe;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	@Column(nullable = false, length = 100)
	private String tabela;

	@Lob
	@Column(nullable = false)
	private String usuario;

	@Lob
	@Column(nullable = false)
	private String valor;

	public Auditoria() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public String getClasse() {

		return this.classe;
	}

	public void setClasse(final String classe) {

		this.classe = classe;
	}

	public Date getData() {

		return this.data;
	}

	public void setData(final Date data) {

		this.data = data;
	}

	public String getTabela() {

		return this.tabela;
	}

	public void setTabela(final String tabela) {

		this.tabela = tabela;
	}

	public String getUsuario() {

		return this.usuario;
	}

	public void setUsuario(final String usuario) {

		this.usuario = usuario;
	}

	public String getValor() {

		return this.valor;
	}

	public void setValor(final String valor) {

		this.valor = valor;
	}

}