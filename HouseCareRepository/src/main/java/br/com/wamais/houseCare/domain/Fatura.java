package br.com.wamais.houseCare.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private Integer idCobranca;

	@Transient
	private Cobranca cobranca;

	@Transient
	private List<Lancamento> lancamentos;

	public Fatura() {

		this.lancamentos = new ArrayList<Lancamento>();

	}

	public int getId() {

		return this.id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public Integer getIdCobranca() {

		return this.idCobranca;
	}

	public void setIdCobranca(final Integer idCobranca) {

		this.idCobranca = idCobranca;
	}

	public List<Lancamento> getLancamentos() {

		return this.lancamentos;
	}

	public void setLancamentos(final List<Lancamento> lancamentos) {

		this.lancamentos = lancamentos;
	}

	public Cobranca getCobranca() {

		return this.cobranca;
	}

	public void setCobranca(final Cobranca cobranca) {

		this.cobranca = cobranca;
	}

}