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
 * The persistent class for the papel_empresa database table.
 *
 */
@Entity
@Table(name = "papel_empresa")
public class PapelEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PapelEmpresaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	@Column(nullable = false, length = 1)
	private String situacao;

	public PapelEmpresa() {

	}

	public PapelEmpresaPK getId() {

		return this.id;
	}

	public void setId(final PapelEmpresaPK id) {

		this.id = id;
	}

	public Date getData() {

		return this.data;
	}

	public void setData(final Date data) {

		this.data = data;
	}

	public String getSituacao() {

		return this.situacao;
	}

	public void setSituacao(final String situacao) {

		this.situacao = situacao;
	}

}