package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="papel_empresa")
public class PapelEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PapelEmpresaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private String situacao;

	public PapelEmpresa() {
	}

	public PapelEmpresaPK getId() {
		return this.id;
	}

	public void setId(PapelEmpresaPK id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}